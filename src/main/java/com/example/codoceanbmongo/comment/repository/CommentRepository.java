package com.example.codoceanbmongo.comment.repository;

import com.example.codoceanbmongo.comment.entity.Comment;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.UUID;

public interface CommentRepository extends MongoRepository<Comment, UUID> {

}