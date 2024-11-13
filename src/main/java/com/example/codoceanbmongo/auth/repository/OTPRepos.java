package com.example.codoceanbmongo.auth.repository;

import com.example.codoceanbmongo.auth.entity.OTP;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface OTPRepos extends MongoRepository<OTP, UUID> {
    OTP findByUserEmailAndType(String email, OTP.EType type);

    OTP findByUserEmail(String email);
}
