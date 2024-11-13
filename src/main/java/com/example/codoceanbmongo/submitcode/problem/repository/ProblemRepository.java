package com.example.codoceanbmongo.submitcode.problem.repository;

import com.example.codoceanbmongo.submitcode.problem.entity.Problem;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface ProblemRepository extends MongoRepository<Problem, UUID> {

    @Query("{ 'isDeleted': false, " +
            "'difficulty': ?0, " +
            "'topics': ?1, " +
            "'title': { $regex: ?2, $options: 'i' }}")
    Page<Problem> findByCriteria(Problem.EDifficulty difficulty, Problem.ETopic topic, String searchTerm, Pageable pageable);

    @Query("{'isDeleted': false, 'owner.email': ?0}")
    List<Problem> getProblemsByOwner(String email);

    @Query("{'isDeleted': false, 'owner.id': ?0, 'title': { $regex: ?1, $options: 'i' }}")
    List<Problem> getProblemsByOwnerAndName(Long userId, String problemName);

    @Query("{'isDeleted': false}")
    List<Problem> findAllProblemAvailable();

    @Query("{ 'topics': { $in: ?0 }, 'submissions': { $exists: true, $ne: [] }}")
    List<Problem> findTopByTopicsOrderBySubmissionsDesc(List<Problem.ETopic> topics, Pageable pageable);

    @Query("{ 'submissions': { $exists: true, $ne: [] }}")
    List<Problem> findTopByOrderBySubmissionsDesc(Pageable pageable);

    @Query("{'isDeleted': false, 'submissions.status': 'ACCEPTED', 'submissions.user.email': ?0}")
    List<Problem> findSolvedProblemsByUser(String email);
}
