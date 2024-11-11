package com.example.codoceanbmongo.discuss.dto;

import com.example.codoceanbmongo.discuss.entity.Discuss;
import lombok.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class DiscussDTO {
    private UUID id;
    private String title;
    private String description;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private LocalDateTime endAt;

    private List<String> imageUrls;
    private int commentCount;
    private int reactCount;

    private UUID ownerId;
    private String ownerName;
    private String ownerImageUrl;
    private boolean isLiked;

    public Discuss toEntity() {
        return Discuss.builder()
                .id(this.id)
                .title(this.title)
                .description(this.description)
                .createdAt(this.createdAt)
                .updatedAt(this.updatedAt)
                .endAt(this.endAt)
                .build();
    }
}
