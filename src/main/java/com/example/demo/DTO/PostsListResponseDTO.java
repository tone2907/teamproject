package com.example.demo.DTO;

import com.example.demo.entity.PostsEntity;
import lombok.Getter;

@Getter
public class PostsListResponseDTO {
    private Long postId;
    private String member;
    private String title;

    public PostsListResponseDTO(PostsEntity entity){
        this.postId = entity.getPostId();
        this.member = entity.getMember().getName();
        this.title = entity.getTitle();
    }
}
