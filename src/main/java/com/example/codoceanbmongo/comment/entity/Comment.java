package com.example.codoceanbmongo.comment.entity;

import com.example.codoceanbmongo.auth.entity.User;
import com.example.codoceanbmongo.comment.dto.CommentDTO;
import com.example.codoceanbmongo.discuss.entity.Discuss;
import com.example.codoceanbmongo.submitcode.problem.entity.Problem;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.UUID;

@Document(collection = "comments")
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class Comment implements Serializable {
    @Id
    private UUID id;

    private String text;

    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;

    private boolean isDeleted;

    @DBRef
    private Comment commentParent;

    @DBRef
    private User user;

    @DBRef
    private Discuss discuss;

    @DBRef
    private Problem problem;

    public CommentDTO toDTO() {
        return CommentDTO.builder()
                .id(id)
                .text(text)
                .updatedAt(updatedAt)
                .ownerId(user.getId())
                .ownerName(user.getFullName())
                .ownerImageUrl(user.getUrlImage())
                .build();
    }
}