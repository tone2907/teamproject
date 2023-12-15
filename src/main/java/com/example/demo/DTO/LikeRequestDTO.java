package com.example.demo.DTO;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class LikeRequestDTO {
    private Long member;
    private Long postId;

    public LikeRequestDTO(Long member, Long postId){
        this.member = member;
        this.postId = postId;
    }
}
