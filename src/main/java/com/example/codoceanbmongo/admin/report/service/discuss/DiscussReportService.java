package com.example.codoceanbmongo.admin.report.service.discuss;

import com.example.codoceanbmongo.admin.report.dto.ReportDTO;
import com.example.codoceanbmongo.discuss.dto.DiscussDTO;

import java.util.List;
import java.util.UUID;


public interface DiscussReportService {
    List<DiscussDTO> getReportedDiscusses();

    List<ReportDTO> getDiscussReports(UUID discussId);

    ReportDTO getReportById(UUID id);

    void lockReport(UUID id, String reason);

    void warnReport(UUID id, String reason);

    void ignoreReport(UUID id);
}
