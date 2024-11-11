package com.example.codoceanbmongo.submitcode.strategy;

import com.example.codoceanbmongo.submitcode.DTO.CustomTestCaseDTO;
import com.example.codoceanbmongo.submitcode.DTO.ResultDTO;
import com.example.codoceanbmongo.submitcode.problem.entity.Problem;
import com.example.codoceanbmongo.submitcode.testcase.entity.TestCase;

import java.util.List;

public interface CompilerStrategy {
    String createInputCode(Problem problem, String code, TestCase testCase);
    void writeFile(String fileLink, String fileName, String code);
    void deleteFileCompiled(String fileLink, String fileName);
    CompilerResult compile(String fileLink, String fileName);
    ResultDTO run(String fileLink, String fileName, String code, Problem problem);
    ResultDTO runWithCustomTestcase(String fileLink, String fileName, List<CustomTestCaseDTO> customTestCaseDTOs, String code, Problem problem);
}
