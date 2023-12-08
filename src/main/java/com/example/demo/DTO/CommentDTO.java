package com.example.demo.DTO;

import com.example.demo.entity.CommentsEntity;
import com.example.demo.entity.MembersEntity;
import com.example.demo.entity.PostsEntity;
import lombok.*;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CommentDTO {
    private Long comment;
    private PostsEntity postId;
    private MembersEntity member;
    private String content;
    private String createDate = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy.MM.dd HH:mm"));
    private String updateDate = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy.MM.dd HH:mm"));
    private Integer deleteStatus;
    private Integer reportStatus;

    public CommentsEntity toEntity(){
        CommentsEntity comments = CommentsEntity.builder()
                .comment(comment)
                .postId(postId)
                .member(member)
                .content(content)
                .createDate(createDate)
                .updateDate(updateDate)
                .delectStatus(deleteStatus)
                .reportStatus(reportStatus)
                .build();
        return comments;
    }

}
