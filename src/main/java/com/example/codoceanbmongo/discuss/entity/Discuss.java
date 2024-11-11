package com.example.codoceanbmongo.discuss.entity;

import com.example.codoceanbmongo.auth.entity.User;
import com.example.codoceanbmongo.comment.entity.Comment;
import com.example.codoceanbmongo.discuss.dto.DiscussDTO;
import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Entity
@Setter
@Getter
@Table(name = "discusses")
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Discuss implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @Column(length = 100000000)
    private String title;

    private String description;

    @Column(name = "created_at")
    private LocalDateTime createdAt;

    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

    @Column(name = "end_at")
    private LocalDateTime endAt;

    @Column(name = "is_closed")
    private boolean isClosed;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
            name = "discuss_categories",
            joinColumns = @JoinColumn(name = "discuss_id"),
            inverseJoinColumns = @JoinColumn(name = "category_id")
    )
    private List<Category> categories;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User owner;

    @OneToMany(mappedBy = "discuss", fetch = FetchType.LAZY)
    private List<Comment> comments;

    @OneToMany(mappedBy = "discuss", fetch = FetchType.LAZY)
    private List<Emoji> emojis;

    @OneToMany(mappedBy = "discuss", fetch = FetchType.LAZY)
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
