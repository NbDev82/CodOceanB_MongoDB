package com.example.codoceanbmongo.submitcode.submission.repository;

import com.example.codoceanbmongo.auth.entity.User;
import com.example.codoceanbmongo.submitcode.problem.entity.Problem;
import com.example.codoceanbmongo.submitcode.submission.entity.Submission;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface SubmissionRepository extends JpaRepository<Submission, UUID> {
    List<Submission> findByUserAndProblem(User user, Problem problem);
    List<Submission> findByUser(User user);
}
