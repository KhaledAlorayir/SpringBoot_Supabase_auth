package com.example.supabaseAuthTest.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class SendPostDTO {

    @NotBlank(message = "title should be included")
    @Size(min = 5, max = 50, message = "title should be between 5-60 characters")
    private String title;
    @NotBlank(message = "body should be included")
    @Size(min = 5, max = 500, message = "body should be between 5-500 characters")
    private String body;

    public void setTitle(String title) {
        this.title = title.trim();
    }

    public void setBody(String body) {
        this.body = body.trim();
    }
}
