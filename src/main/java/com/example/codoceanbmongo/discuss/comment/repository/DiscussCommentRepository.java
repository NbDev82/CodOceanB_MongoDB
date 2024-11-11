package com.example.codoceanbmongo.discuss.comment.repository;

import com.example.codoceanbmongo.comment.entity.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface DiscussCommentRepository extends JpaRepository<Comment, UUID> {

    @Query(value =  "SELECT c " +
                    "FROM Comment c " +
                    "INNER JOIN Discuss d ON d.id = c.discuss.id " +
                    "WHERE d.id = :discussId " +
                    "ORDER BY c.createdAt ASC")
    List<Comment> findAllByDiscussId(UUID discussId);

    @Query(value =  "SELECT c " +
                    "FROM Comment c " +
                    "WHERE c.commentParent.id = :commentId " +
                    "ORDER BY c.createdAt ASC")
    List<Comment> findByCommentParentId(UUID commentId);
}
