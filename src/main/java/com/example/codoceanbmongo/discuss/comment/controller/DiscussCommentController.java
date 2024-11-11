package com.example.codoceanbmongo.discuss.comment.controller;

import com.example.codoceanbmongo.discuss.comment.dto.DiscussCommentDTO;
import com.example.codoceanbmongo.discuss.comment.request.AddCommentRequest;
import com.example.codoceanbmongo.discuss.comment.request.ReplyCommentRequest;
import com.example.codoceanbmongo.discuss.comment.request.UpdateCommentRequest;
import com.example.codoceanbmongo.discuss.comment.service.DiscussCommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/discuss/comments")
@RequiredArgsConstructor
public class DiscussCommentController {

    @Autowired
    private DiscussCommentService commentService;

    @PostMapping
    public ResponseEntity<DiscussCommentDTO> createComment(@RequestBody AddCommentRequest request,
                                                           @RequestHeader("Authorization") String authHeader) {
        DiscussCommentDTO commentDTO = commentService.createComment(request, authHeader);
        return new ResponseEntity<>(commentDTO, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<DiscussCommentDTO>> getAllComments(@RequestParam UUID discussId) {
        List<DiscussCommentDTO> commentDTOs = commentService.getAllCommentsByDiscussId(discussId);
        return new ResponseEntity<>(commentDTOs, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<DiscussCommentDTO> getCommentById(@PathVariable UUID id) {
        DiscussCommentDTO comment = commentService.getCommentById(id);
        return comment != null ? new ResponseEntity<>(comment, HttpStatus.OK)
                               : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PutMapping("/{id}")
    public ResponseEntity<DiscussCommentDTO> updateComment(@PathVariable UUID id, @RequestBody UpdateCommentRequest request) {
        DiscussCommentDTO updatedComment = commentService.updateComment(id, request);
        return updatedComment != null ? new ResponseEntity<>(updatedComment, HttpStatus.OK)
                                      : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteComment(@PathVariable UUID id) {
        boolean isDeleted = commentService.deleteComment(id);
        return isDeleted ? new ResponseEntity<>(HttpStatus.NO_CONTENT)
                         : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PostMapping("/reply")
    public ResponseEntity<DiscussCommentDTO> replyComment(@RequestBody ReplyCommentRequest request,
                                                          @RequestHeader("Authorization") String authHeader) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(commentService.reply(authHeader, request));
    }

    @GetMapping("/replies")
    public ResponseEntity<List<DiscussCommentDTO>> getReplyComments(@RequestParam UUID commentId) {
        List<DiscussCommentDTO> commentDTOs = commentService.getReplies(commentId);
        return ResponseEntity.ok(commentDTOs);
    }
}
