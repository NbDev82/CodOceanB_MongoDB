package com.example.codoceanbmongo.submitcode.DTO;

import lombok.Data;

import java.util.List;

@Data
public class AddProblemRequestDTO {
    private String title;
    private String description;
    private String correctAnswer;
    private String difficulty;
    private List<String> topics;
    private boolean deleted;
    private String functionName;
    private String outputDataType;
}
