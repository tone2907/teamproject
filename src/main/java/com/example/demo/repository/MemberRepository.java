package com.example.demo.repository;

import com.example.demo.entity.MembersEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepository extends JpaRepository<MembersEntity, Long> {
}
