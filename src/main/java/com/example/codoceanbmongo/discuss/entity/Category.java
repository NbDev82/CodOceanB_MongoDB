package com.example.codoceanbmongo.discuss.entity;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;
import java.util.UUID;

@Document(collection = "categories")
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Category {
    @Id
    private UUID id;

    private String name;
    private String description;
    private String imageUrl;

    @DBRef(lazy = true)
    private List<Discuss> discusses;
}
