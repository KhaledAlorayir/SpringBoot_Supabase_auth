package com.example.supabaseAuthTest.controller;

import com.example.supabaseAuthTest.util.Helpers;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

@RestController
@RequestMapping(path = "/api/post")
public class PostController {

    @GetMapping
    public ResponseEntity<HashMap> test() {
        HashMap<String, String> res =new HashMap<>();
        res.put("hello","world");
        System.out.println(Helpers.getAuth().getEmail());
        return ResponseEntity.ok(res);
    }

    @GetMapping(path = "/no")
    public ResponseEntity<String> auth() {
        return ResponseEntity.ok("hello authed");
    }
}
