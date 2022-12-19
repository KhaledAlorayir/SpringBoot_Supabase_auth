package com.example.supabaseAuthTest.repo;

import com.example.supabaseAuthTest.entity.Post;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PostRepo extends JpaRepository<Post,Long> {
    Slice<Post> findByUserId(String userId, Pageable pageable);
}
