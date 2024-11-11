package com.example.codoceanbmongo.statistic.controller;

import com.example.codoceanbmongo.statistic.service.TrendingService;
import com.example.codoceanbmongo.submitcode.DTO.ProblemDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/trending")
public class TrendingController {

    private final TrendingService trendingService;

    @Autowired
    public TrendingController(TrendingService trendingService) {
        this.trendingService = trendingService;
    }

    @GetMapping("/{topic}/{limit}")
    public ResponseEntity<List<ProblemDTO>> getTrendingProblemsWithTopic(@PathVariable String topic, @PathVariable int limit) {
        try {
            return ResponseEntity.ok(trendingService.getTrendingProblems(topic, limit));
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(null);
        }
    }

    @GetMapping("/{limit}")
    public ResponseEntity<List<ProblemDTO>> getTrendingProblems(@PathVariable int limit) {
        try {
            return ResponseEntity.ok(trendingService.getTrendingProblems(limit));
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(null);
        }
    }
}
