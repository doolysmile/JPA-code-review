package com.likelionking.sbbstudy.domain.member.repository;

import com.likelionking.sbbstudy.domain.comment.entity.Comment;
import com.likelionking.sbbstudy.domain.member.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepository extends JpaRepository<Member, Long> {

    Member findByEmail(String email);
}
