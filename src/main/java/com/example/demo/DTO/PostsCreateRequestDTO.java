package com.example.demo.DTO;

import com.example.demo.entity.MembersEntity;
import com.example.demo.entity.PostsEntity;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class PostsCreateRequestDTO {
    private MembersEntity member;
    private String title;
    private String content;

    @Builder
    public PostsCreateRequestDTO(MembersEntity member, String title, String content){
        this.member = member;
        this.title = title;
        this.content = content;
    }
    public PostsEntity toEntity(){
        return PostsEntity.builder()
                .member(member)
                .title(title)
                .content(content)
                .build();
    }
}
