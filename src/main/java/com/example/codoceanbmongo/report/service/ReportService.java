package com.example.codoceanbmongo.report.service;

import com.example.codoceanbmongo.report.dto.ReportDTO;

public interface ReportService {
    boolean createReport(ReportDTO reportDTO, String authHeader);
}
