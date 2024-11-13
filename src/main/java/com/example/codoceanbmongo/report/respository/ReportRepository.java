package com.example.codoceanbmongo.report.respository;

import com.example.codoceanbmongo.report.entity.Report;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface ReportRepository extends MongoRepository<Report, UUID> {
    List<Report> findByTypeAndStatus(Report.EReportType eReportType, Report.EStatus eStatus);
    List<Report> findByStatusAndTypeAndViolationId(Report.EStatus eStatus, Report.EReportType eReportType, UUID commentId);

    void deleteByViolationId(UUID violationId);

    List<Report> findByViolationId(UUID violationId);
}
