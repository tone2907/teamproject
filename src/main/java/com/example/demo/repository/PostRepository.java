package com.example.demo.repository;

import com.example.demo.entity.PostsEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PostRepository extends JpaRepository<PostsEntity, Long> {
    List<PostsEntity> findAllByOrderByPostIdDesc();

    @Modifying
    @Query("update PostsEntity p set p.viewCount = p.viewCount + 1 where p.postId = :postId")
    int updateView(Long postId);
}
