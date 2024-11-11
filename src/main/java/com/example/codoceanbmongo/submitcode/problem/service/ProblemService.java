package com.example.codoceanbmongo.submitcode.problem.service;

import com.example.codoceanbmongo.submitcode.DTO.ProblemDTO;
import com.example.codoceanbmongo.submitcode.problem.entity.Problem;
import com.example.codoceanbmongo.submitcode.request.AddProblemRequest;

import java.util.List;
import java.util.UUID;

public interface ProblemService {
    Problem getEntityByProblemId(UUID problemId);
    <T> T findById(UUID problemId, Class<T> returnType);
    List<Problem> getAll();
    List<ProblemDTO> getAllDTOs();
    Boolean add(AddProblemRequest request, String authHeader);
    Boolean delete(UUID problemId);
    Problem getRandomProblem();
    List<ProblemDTO> getTopProblemsByTopic(String topic, int limit);
    List<ProblemDTO> getAllUploadedProblemsByUser(String authHeader);
    List<ProblemDTO> getAllSolvedProblemsByUser(String authHeader);
    List<ProblemDTO> getTopProblems(int limit);
}
