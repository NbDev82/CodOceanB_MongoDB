package com.example.codoceanbmongo.report.dto;

import com.example.codoceanbmongo.report.entity.Report;
import com.example.codoceanbmongo.report.entity.ViolationType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.logging.log4j.core.config.plugins.validation.constraints.Required;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class ReportDTO {
    @Required
    private Report.EReportType type;
    @Required
    private String description;
    @Required
    private UUID violationId;
    @Required
    private List<ViolationTypeDTO> violationTypes;

    public Report toEntity() {
        return Report.builder()
                .type(type)
                .description(description)
                .violationId(violationId)
                .violationTypes(violationTypes.stream()
                        .map(v -> ViolationType.builder()
                                .description(v.getDescription())
                                .id(v.getId())
                                .build()
                        )
                        .collect(Collectors.toList())
                )
                .build();
    }
}
