package com.example.demo.DTO;

import com.example.demo.entity.MembersEntity;
import com.example.demo.entity.PostsEntity;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.lang.reflect.Member;

@Getter
@NoArgsConstructor
public class PostsCreateRequestDTO {
    private Member member;
    private String title;
    private String content;

    @Builder
    public PostsCreateRequestDTO(Member member, String title, String content){
        this.member = member;
        this.title = title;
        this.content = content;
    }
    public PostsEntity toEntity(){
        return PostsEntity.builder()
                .member((MembersEntity) member)
                .title(title)
                .content(content)
                .build();
    }
}
