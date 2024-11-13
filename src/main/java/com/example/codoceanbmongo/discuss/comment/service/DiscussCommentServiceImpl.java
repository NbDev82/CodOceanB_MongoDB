package com.example.codoceanbmongo.discuss.comment.service;

import com.example.codoceanbmongo.auth.service.UserService;
import com.example.codoceanbmongo.comment.entity.Comment;
import com.example.codoceanbmongo.discuss.comment.dto.DiscussCommentDTO;
import com.example.codoceanbmongo.discuss.comment.exception.CommentNotFoundException;
import com.example.codoceanbmongo.discuss.comment.exception.InvalidCommentLengthException;
import com.example.codoceanbmongo.discuss.comment.repository.DiscussCommentRepository;
import com.example.codoceanbmongo.discuss.comment.request.AddCommentRequest;
import com.example.codoceanbmongo.discuss.comment.request.ReplyCommentRequest;
import com.example.codoceanbmongo.discuss.comment.request.UpdateCommentRequest;
import com.example.codoceanbmongo.discuss.service.DiscussService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class DiscussCommentServiceImpl implements DiscussCommentService{

    @Autowired
    private DiscussCommentRepository commentRepository;

    @Autowired
    private UserService userService;

    @Autowired
    private DiscussService discussService;

    @Autowired
    private DiscussCommentRepository discussCommentRepository;

    @Override
    public DiscussCommentDTO createComment(AddCommentRequest request, String authHeader) {
        Comment comment = Comment.builder()
                .text(request.getText())
                .createdAt(LocalDateTime.now())
                .updatedAt(LocalDateTime.now())
                .isDeleted(false)
                .user(userService.getUserDetailsFromToken(authHeader))
                .discuss(discussService.getDiscuss(request.getDiscussId()))
                .build();
        Comment savedComment = commentRepository.save(comment);
        return convertToDTO(savedComment);
    }

    @Override
    public List<DiscussCommentDTO> getAllCommentsByDiscussId(UUID discussId) {
        List<Comment> comments = commentRepository.findByDiscussIdOrderByCreatedAtAsc(discussId);
        return comments.stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    @Override
    public DiscussCommentDTO getCommentById(UUID id) {
        Comment comment = commentRepository.findById(id)
                .orElseThrow(() -> new CommentNotFoundException("Comment not found"));
        return convertToDTO(comment);
    }

    @Override
    public DiscussCommentDTO updateComment(UUID id, UpdateCommentRequest request) {
        Comment comment = commentRepository.findById(id)
                .orElseThrow(() -> new CommentNotFoundException("Comment not found"));
        comment.setText(request.getText());
        comment.setUpdatedAt(LocalDateTime.now());

        Comment updatedComment = commentRepository.save(comment);
        return convertToDTO(updatedComment);
    }

    @Override
    public boolean deleteComment(UUID id) {
        if (commentRepository.existsById(id)) {
            commentRepository.deleteById(id);
            return true;
        }
        return false;
    }

    @Override
    public DiscussCommentDTO reply(String authHeader, ReplyCommentRequest request) {
        int MINIMUM_LENGTH_OF_MESSAGE = 10;
        if(request.getText().length() < MINIMUM_LENGTH_OF_MESSAGE)
            throw new InvalidCommentLengthException("Comment must not less than 10 characters");
        if (request.getCommentId() == null)
            return null;

        Comment comment = Comment.builder()
                .text(request.getText())
                .createdAt(LocalDateTime.now())
                .updatedAt(LocalDateTime.now())
                .isDeleted(false)
                .user(userService.getUserDetailsFromToken(authHeader))
                .commentParent(discussCommentRepository.findById(request.getCommentId()).orElse(null))
                .build();
        Comment saved = commentRepository.save(comment);

        return convertToDTO(saved);
    }

    @Override
    public List<DiscussCommentDTO> getReplies(UUID commentId) {
        List<Comment> comments = commentRepository.findByCommentParentIdOrderByCreatedAtAsc(commentId);
        return comments.stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    private DiscussCommentDTO convertToDTO(Comment comment) {
        return DiscussCommentDTO.builder()
                .id(comment.getId())
                .text(comment.getText())
                .updatedAt(comment.getUpdatedAt())
                .ownerId(comment.getUser().getId())
                .ownerName(comment.getUser().getFullName())
                .ownerImageUrl(comment.getUser().getUrlImage())
                .build();
    }
}
