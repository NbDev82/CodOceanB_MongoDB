package com.example.codoceanbmongo.discuss.entity;

import lombok.*;

import java.io.Serializable;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class EmojiId implements Serializable {
    private UUID owner;
    private UUID discuss;

    // Convert the composite key to a string representation
    @Override
    public String toString() {
        return owner.toString() + "_" + discuss.toString();
    }
}
