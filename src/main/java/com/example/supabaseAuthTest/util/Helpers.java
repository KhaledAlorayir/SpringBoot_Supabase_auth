package com.example.supabaseAuthTest.util;

import com.example.supabaseAuthTest.dto.UserDTO;
import org.springframework.security.core.context.SecurityContextHolder;

public class Helpers {
    public static UserDTO getAuth() {
        return (UserDTO) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
    }
}
