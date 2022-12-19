package com.example.supabaseAuthTest.service;

import com.example.supabaseAuthTest.dto.PostDTO;
import com.example.supabaseAuthTest.dto.SendPostDTO;
import com.example.supabaseAuthTest.dto.ResourceNotFoundException;
import com.example.supabaseAuthTest.dto.UnAuthorizedException;
import com.example.supabaseAuthTest.entity.Post;
import com.example.supabaseAuthTest.repo.PostRepo;
import com.example.supabaseAuthTest.util.Helpers;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PostService {
    private final PostRepo postRepo;
    private ModelMapper mapper = new ModelMapper();

    public PostDTO create(SendPostDTO postDTO) {
        Post post = postRepo.save(new Post(Helpers.getAuth().getId() , postDTO.getTitle(), postDTO.getBody()));
        return mapper.map(post,PostDTO.class);
    }

    public PostDTO get(long id) {
        return mapper.map(postRepo.findById(id).orElseThrow(() -> new ResourceNotFoundException()),PostDTO.class);
    }

    public void delete(long id) {
        Post post = postRepo.findById(id).orElseThrow(() -> new ResourceNotFoundException());

        if(!post.getUserId().equals(Helpers.getAuth().getId())){
            throw new UnAuthorizedException();
        }

        postRepo.deleteById(id);

    }

    public PostDTO update(long id, SendPostDTO sendPostDTO){
        Post post = postRepo.findById(id).orElseThrow(() -> new ResourceNotFoundException());

        if(!post.getUserId().equals(Helpers.getAuth().getId())){
            throw new UnAuthorizedException();
        }

        post.setBody(sendPostDTO.getBody());
        post.setTitle(sendPostDTO.getTitle());
        postRepo.save(post);
        return mapper.map(post,PostDTO.class);
    }


}
