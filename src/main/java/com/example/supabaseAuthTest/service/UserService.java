package com.example.supabaseAuthTest.service;

import com.example.supabaseAuthTest.dto.PaginationDTO;
import com.example.supabaseAuthTest.dto.PostDTO;
import com.example.supabaseAuthTest.dto.UserDTO;
import com.example.supabaseAuthTest.entity.Post;
import com.example.supabaseAuthTest.repo.PostRepo;
import com.example.supabaseAuthTest.util.Helpers;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Slice;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UserService {

    private final PostRepo postRepo;
    private ModelMapper mapper = new ModelMapper();

    public PaginationDTO<PostDTO> getUserPosts(String uid, int page) {
        Slice<Post> results = postRepo.findByUserId(uid, PageRequest.of(page,10));
        List<PostDTO> list = results.getContent().stream().map((post) -> mapper.map(post,PostDTO.class)).collect(Collectors.toList());
        return new PaginationDTO<>(results.hasNext(),results.getNumber(),list);
    }

}
