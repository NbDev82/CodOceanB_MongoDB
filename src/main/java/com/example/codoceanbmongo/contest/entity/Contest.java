package com.example.codoceanbmongo.contest.entity;

import com.example.codoceanbmongo.auth.entity.User;
import com.example.codoceanbmongo.submitcode.problem.entity.Problem;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;
import java.util.List;
import java.util.UUID;

@Document(collection = "contests")
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class Contest implements Serializable {
    @Id
    private UUID id;

    private String title;

    private String desc;

    private long durationInMillis;

    private boolean isDeleted;

    @DBRef
    private User owner;

    @DBRef
    private List<Problem> problems;

    @DBRef
    private List<ContestEnrollment> contestEnrollments;
}
