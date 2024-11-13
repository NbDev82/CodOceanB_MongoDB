package com.example.codoceanbmongo.auth.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
import java.util.UUID;

@Document(collection = "otps")
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class OTP {
    @Id
    private String id;

    private String encryptedOTP;
    private LocalDateTime expirationDate;
    private EType type;

    @DBRef
    private User user;

    public enum EType {
        FORGOT_PASSWORD,
        ACTIVE_ACCOUNT,
        CHANGE_EMAIL
    }
}
