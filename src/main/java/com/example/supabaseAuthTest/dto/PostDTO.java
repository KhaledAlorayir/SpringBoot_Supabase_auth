package com.example.supabaseAuthTest.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Date;

@Data
public class PostDTO {
    private Long id;
    private Date createdAt;
    private String user_id;
    private String title;
    private String body;

}
