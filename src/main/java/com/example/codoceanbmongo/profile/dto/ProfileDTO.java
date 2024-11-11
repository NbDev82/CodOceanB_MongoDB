package com.example.codoceanbmongo.profile.dto;

import com.example.codoceanbmongo.auth.entity.User;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class ProfileDTO {
    private String fullName;

    private String phoneNumber;

    private LocalDateTime dateOfBirth;

    @NotBlank(message = "Email number is required")
    private String email;
    private String urlImage;

    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;

    private LocalDateTime VIPExpDate;

    private boolean isLocked;

    @NotNull(message = "Role ID is required")
    private User.ERole role;
}
