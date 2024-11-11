package com.example.codoceanbmongo.profile.response;

import com.example.codoceanbmongo.profile.dto.ProfileDTO;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ProfileResponse {
    @JsonProperty("profile")
    private ProfileDTO profile;
}
