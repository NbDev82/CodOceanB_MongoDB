package com.example.codoceanbmongo.submitcode.DTO;

import lombok.Data;

import java.util.List;

@Data
public class AddTestCaseRequestDTO {
    private List<InputDTO> input;
    private String output;
}
