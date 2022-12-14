package com.example.supabaseAuthTest.repo;

import com.example.supabaseAuthTest.entity.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentRepo extends JpaRepository<Comment,Long> {
}
