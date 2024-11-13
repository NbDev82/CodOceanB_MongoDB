package com.example.codoceanbmongo.submitcode.library.entity;

import com.example.codoceanbmongo.submitcode.problem.entity.Problem;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;
import java.util.UUID;

@Document(collection = "library_support")
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class LibrariesSupport implements Serializable {
    @Id
    private UUID id;

    private String name;

    @DBRef
    private Problem problem;
}
