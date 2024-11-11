package com.example.codoceanbmongo.auth.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ChangePasswordResponse {
    @JsonProperty("message")
    private String message;
}
