package com.example.demo.DTO;

import com.example.demo.entity.CommentsEntity;
import com.example.demo.entity.MembersEntity;
import com.example.demo.entity.PostsEntity;
import lombok.Getter;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Getter
public class CommentResponseDTO {
    private Long comment;
    private PostsEntity postId;
    private MembersEntity member;
    private String content;
    private String createDate = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy.MM.dd HH:mm"));
    private String updateDate = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy.MM.dd HH:mm"));
    private Integer deleteStatus;
    private Integer reportStatus;

    public CommentResponseDTO(CommentsEntity commentsEntity){
        this.comment = commentsEntity.getComment();
        this.postId = commentsEntity.getPostId();
        this.member = commentsEntity.getMember();
        this.content = commentsEntity.getContent();
        this.createDate = commentsEntity.getCreateDate();
        this.updateDate = commentsEntity.getUpdateDate();
        this.deleteStatus = commentsEntity.getDelectStatus();
        this.reportStatus = commentsEntity.getReportStatus();
    }
}