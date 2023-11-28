package com.example.demo.service;

import com.example.demo.DTO.PostsCreateRequestDTO;
import com.example.demo.repository.PostRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;



@RequiredArgsConstructor
@Service
public class PostsService {
    private final PostRepository postRepository;

    @Transactional
    public Long create(PostsCreateRequestDTO requestDTO){
        return postRepository.save(requestDTO.toEntity()).getPostId();
    }
}
