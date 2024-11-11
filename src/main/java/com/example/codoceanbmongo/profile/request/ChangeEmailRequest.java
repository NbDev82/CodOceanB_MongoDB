package com.example.codoceanbmongo.profile.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class ChangeEmailRequest {
    private String newEmail;
    private String otp;
}
