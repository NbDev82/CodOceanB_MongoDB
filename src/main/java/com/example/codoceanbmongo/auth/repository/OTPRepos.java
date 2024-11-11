package com.example.codoceanbmongo.auth.repository;

import com.example.codoceanbmongo.auth.entity.OTP;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface OTPRepos extends JpaRepository<OTP, UUID> {
    OTP findByUserEmailAndType(String email, OTP.EType type);

    OTP findByUserEmail(String email);
}
