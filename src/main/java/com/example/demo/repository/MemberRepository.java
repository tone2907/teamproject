package com.example.demo.repository;

import com.example.demo.entity.MembersEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface MemberRepository extends JpaRepository<MembersEntity, Long> {

    Optional<MembersEntity> findByMemberberId(Long member);
}
