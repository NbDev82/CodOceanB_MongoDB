package com.example.codoceanbmongo.discuss.request;

import lombok.*;

import java.util.UUID;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class EmojiRequest {
    private UUID discussId;
}
