package com.example.codoceanbmongo.submitcode.request;

import com.example.codoceanbmongo.submitcode.DTO.CustomTestCaseDTO;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class TestCodeWithCustomTestcaseRequest extends SubmitCodeRequest{
    private List<CustomTestCaseDTO> customTestCaseDTOs;
}
