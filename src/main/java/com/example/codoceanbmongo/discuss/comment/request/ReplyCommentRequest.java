package com.example.codoceanbmongo.discuss.comment.request;

import lombok.*;

import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ReplyCommentRequest {
    private String text;
    private UUID commentId;
}
