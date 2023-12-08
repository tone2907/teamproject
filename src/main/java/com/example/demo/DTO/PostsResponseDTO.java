package com.example.demo.DTO;

import com.example.demo.entity.PostsEntity;
import lombok.Getter;

import java.util.List;
import java.util.stream.Collectors;

@Getter
public class PostsResponseDTO {
    private Long postId;
    private String member;
    private String title;
    private String content;
    private List<CommentResponseDTO> comments;

    public PostsResponseDTO(PostsEntity entity){
        this.postId = entity.getPostId();
        this.member = entity.getMember().getName();
        this.title = entity.getTitle();
        this.content = entity.getContent();
        this.comments = entity.getComments().stream().map(CommentResponseDTO::new).collect(Collectors.toList());
    }
}
