package com.example.supabaseAuthTest.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class Comment {

    public Comment(String body, String user_id, Post post) {
        this.body = body;
        this.user_id = user_id;
        this.post = post;
    }

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
