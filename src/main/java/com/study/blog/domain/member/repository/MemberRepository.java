package com.study.blog.domain.member.repository;

import com.study.blog.domain.member.domain.Member;
import com.study.blog.domain.member.domain.dto.MemberDto;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface MemberRepository extends JpaRepository<Member,Long> {
    boolean existsByMemberName(String memberName);
    Optional<Member> findByMemberName(String memberName);
}
