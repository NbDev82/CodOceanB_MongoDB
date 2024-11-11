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

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "comments")
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class Comment implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    private String text;

    @Column(name = "created_at")
    private LocalDateTime createdAt;

    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

    @Column(name = "is_deleted")
    private boolean isDeleted;

    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "comment_id", referencedColumnName = "id")
    private Comment commentParent;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "discuss_id")
    private Discuss discuss;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "problem_id")
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
