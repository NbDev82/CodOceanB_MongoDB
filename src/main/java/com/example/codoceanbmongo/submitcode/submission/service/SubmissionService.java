package com.example.codoceanbmongo.submitcode.submission.service;

import com.example.codoceanbmongo.auth.entity.User;
import com.example.codoceanbmongo.submitcode.DTO.ResultDTO;
import com.example.codoceanbmongo.submitcode.DTO.SubmissionDTO;
import com.example.codoceanbmongo.submitcode.problem.entity.Problem;
import com.example.codoceanbmongo.submitcode.request.TestCodeWithCustomTestcaseRequest;
import com.example.codoceanbmongo.submitcode.submission.entity.Submission;

import java.util.List;
import java.util.UUID;

public interface SubmissionService {
    String getInputCode(Problem problem, Submission.ELanguage language);
    ResultDTO compile(String authHeader, String code, Submission.ELanguage eLanguage);
    ResultDTO runCode(String authHeader, String code, Problem problem, Submission.ELanguage eLanguage);
    List<SubmissionDTO> getByUserIdAndProblemId(String authHeader, UUID problemId);
    <T> List<T> getByUser(User user, Class<T> returnType);
    ResultDTO testWithCustomTestCases(String authHeader, TestCodeWithCustomTestcaseRequest request);
}
