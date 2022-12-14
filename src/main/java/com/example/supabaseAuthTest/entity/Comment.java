package com.example.supabaseAuthTest.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Comment {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(nullable = false)
    private String body;
    @Column(nullable = false)
    private String user_id;
    @ManyToOne(optional = false)
    @JoinColumn(name = "post_id")
    private Post post;
}
