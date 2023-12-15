package com.example.demo.repository;

import com.example.demo.entity.LikesEntity;
import com.example.demo.entity.MembersEntity;
import com.example.demo.entity.PostsEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface LikeRepository extends JpaRepository<LikesEntity, Long> {
    Optional<LikesEntity> findByMemberAndPosts(MembersEntity members, PostsEntity posts);
}
