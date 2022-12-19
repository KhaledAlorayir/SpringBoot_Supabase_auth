package com.example.supabaseAuthTest.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class SendCommentDTO {
    @NotBlank(message = "body should be included")
    @Size(min = 3, max = 100, message = "body should be between 3-100 characters")
    private String body;

    public void setBody(String body) {
        this.body = body.trim();
    }

}
