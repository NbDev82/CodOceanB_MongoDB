package com.example.codoceanbmongo.auth.service;

import com.example.codoceanbmongo.auth.entity.Token;
import com.example.codoceanbmongo.auth.entity.User;
import com.example.codoceanbmongo.auth.exception.TokenNotFoundException;
import com.example.codoceanbmongo.auth.exception.UserNotFoundException;
import com.example.codoceanbmongo.auth.repository.TokenRepos;
import com.example.codoceanbmongo.auth.repository.UserRepos;
import com.example.codoceanbmongo.auth.request.ChangePasswordRequest;
import com.example.codoceanbmongo.auth.utils.MessageKeys;
import com.example.codoceanbmongo.infras.security.JwtTokenUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("authAccountServiceImpl")
public class AccountServiceImpl implements AccountService {

    @Autowired
    private UserRepos userRepos;
    @Autowired
    private TokenRepos tokenRepos;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private JwtTokenUtils jwtTokenUtil;

    @Override
    public String login(String email, String password) {
        User existingUser = userRepos.findByEmail(email)
                .orElseThrow(() -> new UserNotFoundException("User not found!"));
        if (!passwordEncoder.matches(password, existingUser.getPassword())) {
            throw new BadCredentialsException("Invalid credentials");
        }

        if(existingUser.isFirstLogin()) {
            existingUser.setFirstLogin(false);
            userRepos.save(existingUser);
        }

        return jwtTokenUtil.generateToken(existingUser);
    }

    @Override
    public void changePassword(String bearerToken, ChangePasswordRequest request) {
        String email = jwtTokenUtil.extractEmailFromBearerToken(bearerToken);
        User user = userRepos.findByEmail(email)
                .orElseThrow(() -> new UserNotFoundException("User not found!"));
        
        if (!passwordEncoder.matches(request.getOldPassword(), user.getPassword())) {
            throw new BadCredentialsException("Mật khẩu cũ không đúng");
        }
        
        String encodedPassword = passwordEncoder.encode(request.getNewPassword());
        user.setPassword(encodedPassword);
        userRepos.save(user);
        tokenRepos.deleteByUser(user);
    }

    @Override
    public String resetPassword(String email, String newPassword) {
        User user = userRepos.findByEmail(email)
                .orElseThrow(() -> new UserNotFoundException("User not found"));
        String encodedPassword = passwordEncoder.encode(newPassword);
        user.setPassword(encodedPassword);
        userRepos.save(user);

        Token token = tokenRepos.findByUser(user);
        token.setToken(null);
        tokenRepos.save(token);

        return MessageKeys.REFRESH_PASSWORD_SUCCESSFUL;
    }

    @Override
    public void deleteRefreshToken(String refreshToken) {
        tokenRepos.deleteByToken(refreshToken);
    }

    @Transactional
    @Override
    public String generateAndSaveRefreshToken(String accessToken) {
        String email = jwtTokenUtil.extractEmail(accessToken);
        User user = userRepos.findByEmail(email)
                .orElseThrow(() -> new UserNotFoundException("User not found!"));
        String refreshToken = jwtTokenUtil.generateRefreshToken(accessToken);
        Token savedToken = tokenRepos.findByUser(user);

        if(savedToken == null) {
            Token token = Token.builder()
                    .token(refreshToken)
                    .user(user)
                    .build();
            tokenRepos.save(token);
        } else {
            savedToken.setToken(refreshToken);
            tokenRepos.save(savedToken);
        }

        return refreshToken;
    }

    @Override
    public String refreshToken(String refreshToken) {
        refreshToken = refreshToken.substring(7);
        Token token = tokenRepos.findByToken(refreshToken)
                .orElseThrow(() ->  new TokenNotFoundException("Token not found"));
        return jwtTokenUtil.generateToken(token.getUser());
    }
}
