package com.example.codoceanbmongo.report.respository;

import com.example.codoceanbmongo.report.entity.ViolationType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.UUID;

public interface ViolationTypeRepository extends MongoRepository<ViolationType, UUID> {
}