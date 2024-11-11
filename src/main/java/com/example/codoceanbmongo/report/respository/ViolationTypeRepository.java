package com.example.codoceanbmongo.report.respository;

import com.example.codoceanbmongo.report.entity.ViolationType;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ViolationTypeRepository extends JpaRepository<ViolationType, UUID> {
}
