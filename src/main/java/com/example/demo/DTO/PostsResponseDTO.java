package com.example.demo.DTO;

import com.example.demo.entity.PostsEntity;
import lombok.Getter;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Getter
public class PostsResponseDTO {
    private Long postId;
    private String member;
    private Integer postType;
    private String title;
    private String content;
    private LocalDateTime createDate;
    private LocalDateTime updateDate;
    private String image;
    private Integer viewCount;
    private Boolean delectStatus;
    private Boolean reportStatus;
    private List<CommentResponseDTO> comments;

    public PostsResponseDTO(PostsEntity entity){
        this.postId = entity.getPostId();
        this.member = entity.getMember().getName();
        this.postType = entity.getPostType();
        this.title = entity.getTitle();
        this.content = entity.getContent();
        this.createDate = entity.getCreateDate();
        this.updateDate = entity.getUpdateDate();
        this.image = entity.getImage();
        this.viewCount = entity.getViewCount();
        this.delectStatus = entity.getDelectStatus();
        this.reportStatus = entity.getReportStatus();
        this.comments = entity.getComments().stream().map(CommentResponseDTO::new).collect(Collectors.toList());
    }
}
