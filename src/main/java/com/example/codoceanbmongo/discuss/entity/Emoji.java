package com.example.codoceanbmongo.discuss.entity;

import com.example.codoceanbmongo.auth.entity.User;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "emojis")
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Emoji {
    @Id
    private String id;

    @DBRef
    private User owner;

    @DBRef
    private Discuss discuss;

    @Transient
    public void generateId() {
        if (owner != null && discuss != null) {
            this.id = new EmojiId(owner.getId(), discuss.getId()).toString();
        }
    }
}
