package com.example.supabaseAuthTest.dto;

import lombok.Data;

@Data
public class UserDTO {

    private String id;
    private String aud;
    private String role;
    private String email;

}
