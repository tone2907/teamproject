package com.example.demo.repository;

import com.example.demo.entity.CommentsEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentRepository extends JpaRepository<CommentsEntity, Long> {
}
