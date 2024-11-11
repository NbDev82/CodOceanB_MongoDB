package com.example.codoceanbmongo.search.controller;

import com.example.codoceanbmongo.search.dto.ProblemDTO;
import com.example.codoceanbmongo.search.dto.SearchResultDTO;
import com.example.codoceanbmongo.search.requestmodel.SearchRequest;
import com.example.codoceanbmongo.search.service.SearchService;
import com.example.codoceanbmongo.submitcode.problem.entity.Problem;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/api/search")
public class SearchController {
    private static final Logger log = LogManager.getLogger(SearchController.class);

    @Autowired
    private SearchService searchService;

    @GetMapping("/problems")
    public ResponseEntity<SearchResultDTO> getProblems(
            @RequestParam(defaultValue = "0") int pageNumber,
            @RequestParam(defaultValue = "10") int limit,
            @RequestParam(required = false) SearchRequest.EStatus status,
            @RequestParam(required = false) Problem.EDifficulty difficulty,
            @RequestParam(required = false) Problem.ETopic topic,
            @RequestParam(required = false, defaultValue = "") String searchTerm,
            @RequestHeader(value = "Authorization") String authHeader) {
        SearchRequest request = createSearchRequest(pageNumber, limit, status, difficulty, topic, searchTerm);
        SearchResultDTO searchResultDTO = searchService.getProblems(request, authHeader);
        return ResponseEntity.ok(searchResultDTO);
    }
    
    private SearchRequest createSearchRequest(int pageNumber, int limit, SearchRequest.EStatus status,
                                              Problem.EDifficulty difficulty, Problem.ETopic topic, String searchTerm) {
        return new SearchRequest(pageNumber, limit, status, difficulty, topic, searchTerm);
    }

    @GetMapping("/problems/{problemId}")
    public ResponseEntity<ProblemDTO> getProblemDetail(@PathVariable(value = "problemId") UUID problemId) {
        ProblemDTO problemDetail = searchService.getProblemDetail(problemId);
        return ResponseEntity.ok(problemDetail);
    }
}