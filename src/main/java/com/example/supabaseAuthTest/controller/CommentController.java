package com.example.supabaseAuthTest.controller;

import com.example.supabaseAuthTest.dto.CommentDTO;
import com.example.supabaseAuthTest.dto.PaginationDTO;
import com.example.supabaseAuthTest.dto.SendCommentDTO;
import com.example.supabaseAuthTest.entity.Comment;
import com.example.supabaseAuthTest.service.CommentService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/api/comment")
@RequiredArgsConstructor
public class CommentController {

    private final CommentService commentService;

    @PostMapping(path = "/{id}")
    public ResponseEntity<CommentDTO> comment(@PathVariable long id, @Valid @RequestBody SendCommentDTO commentDTO) {
        return new ResponseEntity<>(commentService.comment(id,commentDTO), HttpStatus.CREATED);
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<PaginationDTO<CommentDTO>> getPostComments(@PathVariable long id, @RequestParam(defaultValue = "0") int page){
        return ResponseEntity.ok(commentService.getPostComments(id,page));
    }

}
