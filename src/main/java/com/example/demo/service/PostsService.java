package com.example.demo.service;

import com.example.demo.DTO.PostsCreateRequestDTO;
import com.example.demo.DTO.PostsListResponseDTO;
import com.example.demo.DTO.PostsResponseDTO;
import com.example.demo.DTO.PostsUpdateRequestDTO;
import com.example.demo.entity.PostsEntity;
import com.example.demo.repository.PostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import org.springframework.data.domain.Pageable;
import java.util.List;
import java.util.stream.Collectors;


@RequiredArgsConstructor
@Service
public class PostsService {
    private final PostRepository postRepository;

    @Transactional
    public Long create(PostsCreateRequestDTO requestDTO) {
        return postRepository.save(requestDTO.toEntity()).getPostId();
    }

    @Transactional
    public Long update(Long postId, PostsUpdateRequestDTO requestDTO) {
        PostsEntity postsEntity = postRepository.findById(postId)
                .orElseThrow(() -> new
                        IllegalArgumentException("해당 게시글이 존재하지 않습니다."));
        postsEntity.update(requestDTO.getTitle(),
                requestDTO.getContent());
        return postId;
    }

    @Transactional(readOnly = true)
    public PostsResponseDTO searchById(Long postId) {
        PostsEntity postsEntity = postRepository.findById(postId).orElseThrow(()
                -> new IllegalArgumentException("해당 게시글이 존재하지 않습니다."));
        return new PostsResponseDTO(postsEntity);
    }

    @Transactional(readOnly = true)
    public List<PostsListResponseDTO> searchAllDesc(){
        return postRepository.findAll().stream()
                .map(PostsListResponseDTO::new)
                .collect(Collectors.toList());
    }

    @Transactional
    public void delete(Long postId){
        PostsEntity postsEntity = postRepository.findById(postId)
                .orElseThrow(() -> new IllegalArgumentException("해당 게시물이 존재하지 않습니다."));
        postRepository.delete(postsEntity);
    }
    @Transactional
    public int updateView(Long postId){
        return postRepository.updateView(postId);
    }

    @Transactional(readOnly = true)
    public Page<PostsEntity> pageList(Pageable pageable){
        return postRepository.findAll(pageable);
    }

}