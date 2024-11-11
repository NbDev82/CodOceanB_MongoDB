package com.example.codoceanbmongo.search.service;

import com.example.codoceanbmongo.search.dto.ProblemDTO;
import com.example.codoceanbmongo.search.dto.SearchResultDTO;
import com.example.codoceanbmongo.search.requestmodel.SearchRequest;

import java.util.UUID;

public interface SearchService {
    SearchResultDTO getProblems(SearchRequest request, String authHeader);

    ProblemDTO getProblemDetail(UUID id);
}
