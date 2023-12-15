package com.example.demo.controller;

import com.example.demo.DTO.CommentDTO;
import com.example.demo.service.CommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/api")
@RestController
@RequiredArgsConstructor
public class CommentController {
    private final CommentService commentService;

    @PostMapping("/Article/{postId}/comment")
    public ResponseEntity commentSave(@PathVariable Long postId, @RequestBody CommentDTO dto){
        return ResponseEntity.ok(commentService.commentSave(postId,dto));
    }
    @PutMapping({"/Article/{postId}/comment{id}"})
    public ResponseEntity<Long> update(@PathVariable Long postId, @PathVariable Long comment,@RequestBody CommentDTO dto){
        commentService.update(postId, comment, dto);
        return ResponseEntity.ok(comment);
    }
    @DeleteMapping({"/Article/{postId}/comments/{id}"})
    public ResponseEntity<Long> delete(@PathVariable Long postId, @PathVariable Long comment){
        commentService.delete(postId, comment);
        return ResponseEntity.ok(comment);
    }

}
