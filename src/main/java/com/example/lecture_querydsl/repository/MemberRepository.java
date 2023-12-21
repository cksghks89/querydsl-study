package com.example.lecture_querydsl.repository;

import com.example.lecture_querydsl.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MemberRepository extends JpaRepository<Member, Long>, MemberRepositoryCustom {
    // select m from Member m where m.username = :username;
    List<Member> findByUsername(String username);
}
