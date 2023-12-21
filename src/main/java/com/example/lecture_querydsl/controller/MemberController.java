package com.example.lecture_querydsl.controller;

import com.example.lecture_querydsl.dto.MemberSearchCondition;
import com.example.lecture_querydsl.dto.MemberTeamDto;
import com.example.lecture_querydsl.repository.MemberJpaRepository;
import com.example.lecture_querydsl.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@Slf4j
public class MemberController {

    private final MemberJpaRepository memberJpaRepository;
    private final MemberRepository memberRepository;

    @GetMapping("/v1/members")
    public List<MemberTeamDto> searchMemberV1( MemberSearchCondition condition) {
        log.info("condition : {}", condition);
        return memberJpaRepository.search(condition);
    }

    @GetMapping("/v2/members")
    public Page<MemberTeamDto> searchMemberV2(MemberSearchCondition condition, Pageable pageable) {
        log.info("condition : {}", condition);
        return memberRepository.searchPageSimple(condition, pageable);
    }

    @GetMapping("/v3/members")
    public Page<MemberTeamDto> searchMemberV3(MemberSearchCondition condition, Pageable pageable) {
        log.info("condition : {}", condition);
        return memberRepository.searchPageComplex(condition, pageable);
    }

}
