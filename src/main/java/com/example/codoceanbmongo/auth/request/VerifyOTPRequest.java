package com.example.codoceanbmongo.auth.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class VerifyOTPRequest {
    @JsonProperty("otp")
    private String otp;
    @JsonProperty("email")
    private String email;
}
