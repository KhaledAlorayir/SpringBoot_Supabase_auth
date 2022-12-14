package com.example.supabaseAuthTest.repo;

import com.example.supabaseAuthTest.entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepo extends JpaRepository<Post,Long> {
}
