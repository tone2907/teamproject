package com.example.demo.controller;

import com.example.demo.DTO.PostsCreateRequestDTO;
import com.example.demo.DTO.PostsListResponseDTO;
import com.example.demo.DTO.PostsResponseDTO;
import com.example.demo.DTO.PostsUpdateRequestDTO;
import com.example.demo.service.PostsService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class PostsController {
    private final PostsService postsService;

    @PostMapping("/posts")
    public Long create(@RequestBody PostsCreateRequestDTO requestDTO){
        return postsService.create(requestDTO);
    }
    @PutMapping("/posts/{postId}")
    public Long update(@PathVariable Long postId, @RequestBody PostsUpdateRequestDTO requestDTO){
        return postsService.update(postId, requestDTO);
    }
    @GetMapping("/posts/{postId}")
    public PostsResponseDTO searchById(@PathVariable Long postId){
        return postsService.searchById(postId);
    }
    @GetMapping("/posts")
    public List<PostsListResponseDTO> searchAllDesc(){
        return postsService.searchAllDesc();
    }
}
