package com.example.codoceanbmongo.infras.service;

import com.example.codoceanbmongo.auth.entity.OTP;

public interface EmailService {
    void sendHtmlContent(String toEmail, String subject, String htmlBody);

    String createHtmlEmailContentWithOTP(String otpString, OTP.EType type);
}
