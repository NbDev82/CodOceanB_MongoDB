package com.example.codoceanbmongo.submitcode.testcase.repository;

import com.example.codoceanbmongo.submitcode.testcase.entity.TestCase;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface TestCaseRepository extends MongoRepository<TestCase, UUID> {

    @Query("{'problem.id': ?0, 'isPublic': true}")
    List<TestCase> getPublicTestCasesByProblemId(UUID problemId);
}
