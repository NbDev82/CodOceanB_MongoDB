package com.example.codoceanbmongo.auth.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class UserDTO {
    private String fullName;
    private String phoneNumber;
    private LocalDateTime dateOfBirth;

    @NotBlank(message = "Email number is required")
    private String email;
    private String urlImage;
    private String password;

    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
