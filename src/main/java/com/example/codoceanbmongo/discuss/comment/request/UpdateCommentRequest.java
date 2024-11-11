package com.example.codoceanbmongo.discuss.comment.request;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UpdateCommentRequest{
    private String text;
}
