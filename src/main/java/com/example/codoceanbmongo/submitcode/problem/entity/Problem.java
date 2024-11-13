package com.example.codoceanbmongo.submitcode.problem.entity;

import com.example.codoceanbmongo.auth.entity.User;
import com.example.codoceanbmongo.comment.entity.Comment;
import com.example.codoceanbmongo.contest.entity.Contest;
import com.example.codoceanbmongo.submitcode.DTO.ProblemDTO;
import com.example.codoceanbmongo.submitcode.library.entity.LibrariesSupport;
import com.example.codoceanbmongo.submitcode.submission.entity.Submission;
import com.example.codoceanbmongo.submitcode.testcase.entity.TestCase;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;
import java.text.DecimalFormat;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Document(collection = "problems")
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class Problem implements Serializable {
    @Id
    private UUID id;

    private String title;

    private String description;

    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;

    private String functionName;

    private String correctAnswer;

    private String outputDataType;

    private EDifficulty difficulty;

    private boolean isDeleted;

    private List<ETopic> topics;

    @DBRef
    private User owner;

    @DBRef
    private List<Contest> contests;

    @DBRef
    private List<LibrariesSupport> librariesSupports;

    @DBRef
    private List<TestCase> testCases;

    @DBRef
    private List<Comment> comments;

    @DBRef
    private List<Submission> submissions;

    public enum EDifficulty {
        EASY, NORMAL, HARD;
    }

    @Getter
    public enum ETopic {
        DIVIDE_AND_CONQUER,
        TREE,
        GRAPH,
        DYNAMIC_PROGRAMMING,
        BIT_MANIPULATION,
        BACKTRACKING,
        STRING,
        ARRAY,
        SORTING,
        MATH,
        GREEDY,
        RECURSION,
    }

    public ProblemDTO toDTO() {
        int acceptedCount = this.getSubmissions() != null ? (int) this.getSubmissions().stream().filter(s -> s.getStatus().equals(Submission.EStatus.ACCEPTED)).count() : 0;
        int submissionCount = this.getSubmissions() != null ? this.getSubmissions().size() : 0;
        int commentCount = this.getComments() != null ? (int) this.getComments().stream().filter(c -> !c.isDeleted()).count() : 0;
        String acceptanceRate = getAcceptanceRate(acceptedCount, submissionCount);
        return ProblemDTO.builder()
                .id(id)
                .title(title)
                .description(description)
                .difficulty(difficulty.name())
                .acceptedCount(acceptedCount)
                .submissionCount(submissionCount)
                .discussCount(commentCount)
                .acceptanceRate(acceptanceRate)
                .build();
    }

    private String getAcceptanceRate(int acceptedCount, int submissionCount) {
        double acceptanceRate = ((double) acceptedCount / submissionCount) * 100;
        double roundedNumber = Math.round(acceptanceRate * 10.0) / 10.0;
        DecimalFormat df = new DecimalFormat("#.#");
        return df.format(roundedNumber);
    }
}