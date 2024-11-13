package com.example.codoceanbmongo.auth.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;

@Document(collection = "tokens")
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class Token implements Serializable {
    @Id
    private String id;

    private String token;

    @DBRef
    private User user;
}
