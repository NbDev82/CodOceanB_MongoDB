package com.example.codoceanbmongo.submitcode.testcase.service;

import com.example.codoceanbmongo.submitcode.DTO.PublicTestCaseDTO;

import java.util.List;
import java.util.UUID;

public interface TestCaseService {
    List<PublicTestCaseDTO> getPublicTestCases(UUID problemId);
}
