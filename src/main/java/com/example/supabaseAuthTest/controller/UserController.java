package com.example.supabaseAuthTest.controller;

import com.example.supabaseAuthTest.dto.PaginationDTO;
import com.example.supabaseAuthTest.dto.PostDTO;
import com.example.supabaseAuthTest.entity.Post;
import com.example.supabaseAuthTest.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Slice;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/api/user")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping("/{id}/posts")
    public ResponseEntity<PaginationDTO<PostDTO>> getUserPosts(@PathVariable String id, @RequestParam(defaultValue = "0") int page) {
        return ResponseEntity.ok(userService.getUserPosts(id,page));
    }

}
