package com.example.codoceanbmongo.discuss.comment.repository;

import com.example.codoceanbmongo.comment.entity.Comment;
import org.springframework.data.mongodb.repository.Aggregation;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface DiscussCommentRepository extends MongoRepository<Comment, UUID> {

    // Finds all comments by discussId, ordered by createdAt in ascending order
    List<Comment> findByDiscussIdOrderByCreatedAtAsc(UUID discussId);

    // Finds all comments by commentParent's id, ordered by createdAt in ascending order
    List<Comment> findByCommentParentIdOrderByCreatedAtAsc(UUID commentId);
}
