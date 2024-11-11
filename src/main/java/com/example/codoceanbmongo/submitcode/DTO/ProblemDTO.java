package com.example.codoceanbmongo.submitcode.DTO;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class ProblemDTO {
    private UUID id;
    private String title;
    private String description;
    private String difficulty;
    private int acceptedCount;
    private int discussCount;
    private int submissionCount;
    private String acceptanceRate;
}
