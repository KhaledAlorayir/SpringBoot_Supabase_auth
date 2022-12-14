package com.example.supabaseAuthTest.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;

import java.util.Date;
import java.util.List;

@Entity
@Data
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @CreationTimestamp
    @Column(name = "created_at")
    private Date createdAt;
    @Column(nullable = false, unique = true)
    private String slug;
    @Column(nullable = false)
    private String user_id;
    @Column(nullable = false)
    private String title;
    @Column(nullable = false)
    private String body;
    @OneToMany(mappedBy = "post", cascade = CascadeType.REMOVE)
    private List<Comment> comments;
}
