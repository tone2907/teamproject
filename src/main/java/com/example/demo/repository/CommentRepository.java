package com.example.demo.repository;

import com.example.demo.entity.CommentsEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CommentRepository extends JpaRepository<CommentsEntity, Long> {
    Optional<CommentsEntity> findByPostsIdAndId(Long postsId, Long id);
}
