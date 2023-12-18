package com.example.lecture_querydsl.controller;

import com.example.lecture_querydsl.dto.MemberSearchCondition;
import com.example.lecture_querydsl.dto.MemberTeamDto;
import com.example.lecture_querydsl.repository.MemberJpaRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@Slf4j
public class MemberController {

    private final MemberJpaRepository memberJpaRepository;

    @GetMapping("/v1/members")
    public List<MemberTeamDto> searchMemberV1( MemberSearchCondition condition) {
        log.info("condition : {}", condition);
        return memberJpaRepository.search(condition);
    }
}
