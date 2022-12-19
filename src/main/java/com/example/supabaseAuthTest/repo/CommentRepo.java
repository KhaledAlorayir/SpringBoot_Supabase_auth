package com.example.supabaseAuthTest.repo;

import com.example.supabaseAuthTest.entity.Comment;
import com.example.supabaseAuthTest.entity.Post;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentRepo extends JpaRepository<Comment,Long> {
    Slice<Comment> findByPost(Post post, Pageable pageable);
}
