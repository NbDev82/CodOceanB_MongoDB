package com.example.codoceanbmongo.auth.response;

import com.example.codoceanbmongo.auth.entity.User;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class LoginResponse {
    @JsonProperty("accessToken")
    private String accessToken;
    @JsonProperty("refreshToken")
    private String refreshToken;
    @JsonProperty("message")
    private String message;
    @JsonProperty("isActive")
    private Boolean isActive;
    @JsonProperty("isFirstLogin")
    private Boolean isFirstLogin;
    @JsonProperty("role")
    private User.ERole role;

}
