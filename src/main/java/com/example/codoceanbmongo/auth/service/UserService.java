package com.example.codoceanbmongo.auth.service;

import com.example.codoceanbmongo.auth.dto.UserDTO;
import com.example.codoceanbmongo.auth.entity.User;
import com.example.codoceanbmongo.profile.dto.ProfileDTO;
import com.example.codoceanbmongo.profile.response.ProfileResponse;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.UUID;


@Service
public interface UserService {
    Boolean createUser(UserDTO userDTO);
    User getUserDetailsFromToken(String token);
    User getUserDetailsFromCleanToken(String token);
    ProfileResponse getProfile(String token);
    ProfileResponse getProfile(UUID userId);
    ProfileResponse  changeProfile(String token, ProfileDTO profileDTO);
    ProfileResponse changeProfile(UUID userId, ProfileDTO profileDTO);
    User getEntityUserById(UUID userId);
    UserDTO getUserById(UUID userId);

    ProfileResponse changeEmail(String token, String otp, String newEmail);
    String changeAvatar(String authHeader, MultipartFile file);
    UserDTO getCurrentUser(String authHeader);
}
