package com.example.demo.controller;

import com.example.demo.DTO.PostsCreateRequestDTO;
import com.example.demo.service.PostsService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class PostsController {
    private final PostsService postsService;

    @PostMapping("/posts")
    public Long create(@RequestBody PostsCreateRequestDTO requestDTO){
        return postsService.create(requestDTO);
    }
}
