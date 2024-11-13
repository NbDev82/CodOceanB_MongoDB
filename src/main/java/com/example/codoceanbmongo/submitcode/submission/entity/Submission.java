package com.example.codoceanbmongo.submitcode.submission.entity;

import com.example.codoceanbmongo.auth.entity.User;
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

@Document(collection = "submissions")
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class Submission implements Serializable {
    @Id
    private UUID id;

    private ELanguage language;

    private String codeSubmitted;

    private EStatus status;

    private double runtime;

    private double memory;

    private LocalDateTime createdAt;

    @DBRef
    private User user;

    @DBRef
    private Problem problem;

    public enum ELanguage {
        JAVA, PYTHON, CSHARP;
    }

    public enum EStatus {
        ACCEPTED, WRONG_ANSWER, COMPILE_ERROR, TIME_LIMIT_EXCEEDED;
    }
}