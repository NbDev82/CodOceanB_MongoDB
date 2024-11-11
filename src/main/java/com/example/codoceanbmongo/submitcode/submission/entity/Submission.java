package com.example.codoceanbmongo.submitcode.submission.entity;

import com.example.codoceanbmongo.auth.entity.User;
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
@Table(name = "submissions")
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class Submission implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @Enumerated(EnumType.STRING)
    private ELanguage language;

    @Column(name = "code_submitted", columnDefinition = "text")
    private String codeSubmitted;

    @Enumerated(EnumType.STRING)
    private EStatus status;

    private double runtime;

    private double memory;

    @Column(name = "created_at")
    private LocalDateTime createdAt;

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "problem_id")
    private Problem problem;

    public enum ELanguage {
        JAVA, PYTHON, CSHARP;
    }

    public enum EStatus {
        ACCEPTED, WRONG_ANSWER, COMPILE_ERROR, TIME_LIMIT_EXCEEDED;
    }
}
