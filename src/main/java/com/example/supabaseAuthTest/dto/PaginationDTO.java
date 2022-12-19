package com.example.supabaseAuthTest.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PaginationDTO<T> {

    private boolean has_next;
    private int current_page;
    private List<T> data;

}
