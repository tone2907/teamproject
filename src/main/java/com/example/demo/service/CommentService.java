package com.example.demo.service;

import com.example.demo.DTO.CommentDTO;
import com.example.demo.entity.CommentsEntity;
import com.example.demo.entity.PostsEntity;
import com.example.demo.repository.CommentRepository;
import com.example.demo.repository.PostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class CommentService {
    private final CommentRepository commentRepository;
    private final PostRepository postRepository;

    @Transactional
    public Long commentSave(Long postId, CommentDTO dto){
        PostsEntity postsEntity = postRepository.findById(postId).orElseThrow(()->
                new IllegalArgumentException("댓글 쓰기 실패: 해당 게시글이 존재하지 않습니다." + postId));

        dto.setPostId(postsEntity);

        CommentsEntity commentsEntity = dto.toEntity();
        commentRepository.save(commentsEntity);

        return dto.getComment();
    }

}
