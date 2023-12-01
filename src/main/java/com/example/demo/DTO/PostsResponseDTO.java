package com.example.demo.DTO;

import com.example.demo.entity.PostsEntity;
import lombok.Getter;

@Getter
public class PostsResponseDTO {
    private Long postId;
    private String member;
    private String title;
    private String content;

    public PostsResponseDTO(PostsEntity entity){
        this.postId = entity.getPostId();
        this.member = entity.getMember().getName();
        this.title = entity.getTitle();
        this.content = entity.getContent();
    }

}
