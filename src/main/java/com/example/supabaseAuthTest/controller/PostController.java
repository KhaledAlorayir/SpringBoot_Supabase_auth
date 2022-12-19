package com.example.supabaseAuthTest.controller;

import com.example.supabaseAuthTest.dto.PostDTO;
import com.example.supabaseAuthTest.dto.SendPostDTO;
import com.example.supabaseAuthTest.entity.Post;
import com.example.supabaseAuthTest.service.PostService;
import com.example.supabaseAuthTest.util.Helpers;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;

@RestController
@RequestMapping(path = "/api/post")
@RequiredArgsConstructor
public class PostController {

    private final PostService postService;

    @PostMapping
    public ResponseEntity<PostDTO> create(@Valid @RequestBody SendPostDTO postDTO) {
        return new ResponseEntity<>(postService.create(postDTO), HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<PostDTO> get(@PathVariable long id){
        return ResponseEntity.ok(postService.get(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<HashMap<String,String>> delete(@PathVariable long id){
        postService.delete(id);
        HashMap<String,String> res = new HashMap<>();
        res.put("message","post has been deleted");
        return ResponseEntity.ok(res);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<PostDTO> update(@PathVariable long id, @Valid @RequestBody SendPostDTO postDTO) {
        return ResponseEntity.ok(postService.update(id,postDTO));
    }
}
