package com.example.codoceanbmongo.discuss.entity;

import com.example.codoceanbmongo.auth.entity.User;
import com.example.codoceanbmongo.comment.entity.Comment;
import com.example.codoceanbmongo.discuss.dto.DiscussDTO;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Document(collection = "discusses")
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Discuss implements Serializable {
    @Id
    private UUID id;

    private String title;

    private String description;

    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;

    private LocalDateTime endAt;

    private boolean isClosed;

    @DBRef(lazy = true)
    private List<Category> categories;

    @DBRef(lazy = true)
    private User owner;

    @DBRef(lazy = true)
    private List<Comment> comments;

    @DBRef(lazy = true)
    private List<Emoji> emojis;

    @DBRef(lazy = true)
    private List<Image> images;

    public DiscussDTO toDTO(UUID userId) {
        return DiscussDTO.builder()
                .id(this.getId())
                .title(this.getTitle())
                .description(this.getDescription())
                .createdAt(this.getCreatedAt())
                .updatedAt(this.getUpdatedAt())
                .endAt(this.getEndAt())
                .imageUrls(this.getImages().stream().map(Image::getImageUrl).collect(Collectors.toList()))
                .commentCount(this.getComments() == null ? 0 : this.getComments().size())
                .reactCount(this.getEmojis() == null ? 0 : this.getEmojis().size())
                .ownerId(this.getOwner().getId())
                .ownerImageUrl(this.getOwner().getUrlImage() != null ? this.getOwner().getUrlImage() : "")
                .ownerName(this.getOwner().getFullName() != null ? this.getOwner().getFullName() : "")
                .isLiked(this.getEmojis() != null && this.getEmojis().stream().anyMatch(emoji -> emoji.getOwner().getId().equals(userId)))
                .build();
    }
}