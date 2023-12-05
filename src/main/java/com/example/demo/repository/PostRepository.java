package com.example.demo.repository;

import com.example.demo.entity.PostsEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PostRepository extends JpaRepository<PostsEntity, Long> {
    List<PostsEntity> findAllByOrderByPostIdDesc();
}
