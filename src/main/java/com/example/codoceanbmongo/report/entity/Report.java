package com.example.codoceanbmongo.report.entity;

import com.example.codoceanbmongo.admin.report.dto.ReportDTO;
import com.example.codoceanbmongo.admin.report.dto.ViolationTypeDTO;
import com.example.codoceanbmongo.auth.entity.User;
import jakarta.persistence.*;
import lombok.*;
import org.apache.logging.log4j.core.config.plugins.validation.constraints.Required;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Entity
@Table(name = "reports")
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class Report {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    private EReportType type;
    private String description;

    private EStatus status;
    private String reason;

    @Column(name = "created_at")
    private LocalDateTime createdAt;

    @Required
    private UUID violationId;

    @OneToMany
    private List<ViolationType> violationTypes;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "owner_id")
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
