package com.example.codoceanbmongo.report.controller;

import com.example.codoceanbmongo.report.dto.ReportDTO;
import com.example.codoceanbmongo.report.service.ReportService;
import lombok.NonNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/reports")
public class ReportController {
    @Autowired
    private ReportService reportService;

    @PostMapping
    public ResponseEntity<Boolean> createReport(@RequestBody @NonNull ReportDTO report,
                                                @RequestHeader String authHeader) {
        return ResponseEntity.ok(reportService.createReport(report, authHeader));
    }
}
