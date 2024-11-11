package com.example.codoceanbmongo.statistic.service;

import com.example.codoceanbmongo.submitcode.DTO.ProblemDTO;

import java.util.List;

public interface TrendingService {
    List<ProblemDTO> getTrendingProblems(String topic, int limit);
    List<ProblemDTO> getTrendingProblems(int limit);
}
