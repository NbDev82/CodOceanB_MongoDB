package com.example.codoceanbmongo.auth.service;

import com.example.codoceanbmongo.auth.entity.OTP;

public interface OTPService {
    boolean requestOTP(String tokenOrEmail, OTP.EType type);
    boolean verify(String tokenOrEmail, String otp, OTP.EType eType);
}
