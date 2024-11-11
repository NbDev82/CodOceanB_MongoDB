package com.example.codoceanbmongo.discuss.response;

import com.example.codoceanbmongo.discuss.dto.DiscussDTO;
import lombok.*;

import java.util.List;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class DiscussResponse {
    List<DiscussDTO> discussDTOs;
}
