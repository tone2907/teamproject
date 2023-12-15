package com.example.demo.service;

import com.example.demo.DTO.LikeRequestDTO;
import com.example.demo.entity.LikesEntity;
import com.example.demo.entity.MembersEntity;
import com.example.demo.entity.PostsEntity;
import com.example.demo.repository.LikeRepository;
import com.example.demo.repository.MemberRepository;
import com.example.demo.repository.PostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class LikeService {
    private final LikeRepository likeRepository;
    private final MemberRepository memberRepository;
    private final PostRepository postRepository;

    @Transactional
    public void insert(LikeRequestDTO likeRequestDTO) throws Exception{
        MembersEntity members = memberRepository.findById(likeRequestDTO.getMember())
                .orElseThrow(() -> new ChangeSetPersister.NotFoundException());
        PostsEntity posts = postRepository.findById(likeRequestDTO.getPostId())
                .orElseThrow(() -> new ChangeSetPersister.NotFoundException());
        if(likeRepository.findByMemberAndPosts(members,posts).isPresent()){
            throw new Exception();
        }
        LikesEntity likes = LikesEntity.builder()
                .member(members)
                .build();
        likeRepository.save(likes);
    }
    @Transactional
    public void delete(LikeRequestDTO likeRequestDTO) throws ChangeSetPersister.NotFoundException {
        MembersEntity members = memberRepository.findById(likeRequestDTO.getMember())
                .orElseThrow(() -> new ChangeSetPersister.NotFoundException());
        PostsEntity posts = postRepository.findById(likeRequestDTO.getPostId())
                .orElseThrow(() -> new ChangeSetPersister.NotFoundException());
        LikesEntity likes = likeRepository.findByMemberAndPosts(members, posts)
                .orElseThrow(()-> new ChangeSetPersister.NotFoundException());
        likeRepository.delete(likes);
    }
}
