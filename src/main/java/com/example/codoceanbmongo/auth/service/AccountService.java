package com.example.codoceanbmongo.auth.service;

import com.example.codoceanbmongo.auth.request.ChangePasswordRequest;

public interface AccountService {
    String login(String email, String password) throws Exception;
    void changePassword(String bearerToken, ChangePasswordRequest request);

    String resetPassword(String email, String newPassword);

    void deleteRefreshToken(String refreshToken);

    String generateAndSaveRefreshToken(String accessToken);

    String refreshToken(String refreshToken);
}
