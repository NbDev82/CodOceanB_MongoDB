package com.example.codoceanbmongo.admin.report.service.comment;

import com.example.codoceanbmongo.admin.report.dto.ReportDTO;
import com.example.codoceanbmongo.comment.dto.CommentDTO;

import java.util.List;
import java.util.UUID;

public interface CommentReportService {
    List<CommentDTO> getReportedComments();

    List<ReportDTO> getReports(UUID commentId);

    ReportDTO getReportById(UUID id);

    void lockReport(UUID id, String reason);

    void warnReport(UUID id, String reason);

    void ignoreReport(UUID id);
}
