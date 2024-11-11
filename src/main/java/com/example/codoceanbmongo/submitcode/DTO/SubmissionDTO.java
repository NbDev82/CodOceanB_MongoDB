package com.example.codoceanbmongo.submitcode.DTO;

import com.example.codoceanbmongo.submitcode.submission.entity.Submission;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;


@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class SubmissionDTO {
    private UUID id;
    private Submission.ELanguage language;
    private String codeSubmitted;
    private double score;
    private Submission.EStatus status;
    private String runtime;
    private String memory;
    private String createdAt;
}
