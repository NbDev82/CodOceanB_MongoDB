package com.example.codoceanbmongo.submitcode.parameter.repository;

import com.example.codoceanbmongo.submitcode.parameter.entity.Parameter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface ParameterRepository extends MongoRepository<Parameter, UUID> {
}
