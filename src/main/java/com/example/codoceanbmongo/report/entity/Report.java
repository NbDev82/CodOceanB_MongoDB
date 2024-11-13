package com.example.codoceanbmongo.report.entity;

import com.example.codoceanbmongo.admin.report.dto.ReportDTO;
import com.example.codoceanbmongo.admin.report.dto.ViolationTypeDTO;
import com.example.codoceanbmongo.auth.entity.User;
import jakarta.persistence.*;
import lombok.*;
import org.apache.logging.log4j.core.config.plugins.validation.constraints.Required;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Document(collection = "reports")
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class Report {
    @Id
    private UUID id;

    private EReportType type;
    private String description;

    private EStatus status;
    private String reason;

    private LocalDateTime createdAt;

    private UUID violationId;

    @DBRef
    private List<ViolationType> violationTypes;

    @DBRef
    private User owner;

    @Getter
    public enum EReportType {
        PROBLEM,
        DISCUSS,
        COMMENT
    }

    @Getter
    public enum EStatus {
        WAITING,
        FINISH,
        WARMING,
        SERIOUS
    }

    public ReportDTO toDTO() {
        return ReportDTO.builder()
                .id(id)
                .type(type)
                .description(description)
                .violationId(violationId)
                .violationTypes(violationTypes.stream()
                        .map(v ->
                                ViolationTypeDTO.builder()
                                        .description(v.getDescription())
                                        .id(v.getId())
                                        .build()
                        )
                        .collect(Collectors.toList()
                        )
                )
                .ownerId(owner.getId())
                .build();
    }
}
