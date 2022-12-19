package com.example.supabaseAuthTest.service;

import com.example.supabaseAuthTest.dto.CommentDTO;
import com.example.supabaseAuthTest.dto.PaginationDTO;
import com.example.supabaseAuthTest.dto.ResourceNotFoundException;
import com.example.supabaseAuthTest.dto.SendCommentDTO;
import com.example.supabaseAuthTest.entity.Comment;
import com.example.supabaseAuthTest.entity.Post;
import com.example.supabaseAuthTest.repo.CommentRepo;
import com.example.supabaseAuthTest.repo.PostRepo;
import com.example.supabaseAuthTest.util.Helpers;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CommentService {

    private final CommentRepo commentRepo;
    private final PostRepo postRepo;


    public CommentDTO comment(long postId, SendCommentDTO commentDTO) {
        Post post = postRepo.findById(postId).orElseThrow(() -> new ResourceNotFoundException());
        Comment comment = new Comment(commentDTO.getBody(), Helpers.getAuth().getId(), post);
        commentRepo.save(comment);
        return new CommentDTO(comment.getId(),comment.getBody(),comment.getUser_id(),postId);
    }

    public PaginationDTO<CommentDTO> getPostComments(long postId, int page) {
        Post post = postRepo.findById(postId).orElseThrow(() -> new ResourceNotFoundException());
        Slice<Comment> results = commentRepo.findByPost(post, PageRequest.of(page,10));
        List<CommentDTO> comments = results.getContent().stream().map((comment) -> new CommentDTO(comment.getId(),comment.getBody(),comment.getUser_id(),postId)).collect(Collectors.toList());
        return new PaginationDTO<>(results.hasNext(),page,comments);
    }

}
