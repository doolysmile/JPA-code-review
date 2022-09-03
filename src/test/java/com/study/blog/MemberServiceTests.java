package com.study.blog;

import com.study.blog.domain.member.domain.dto.MemberDto;
import com.study.blog.domain.member.service.MemberService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@Transactional
public class MemberServiceTests {
    @Autowired
    MemberService memberService;

    @Test
    @DisplayName("memberName이 u1, email이 u1@test.com, 비밀번호가 1234인 u1 멤버 생성")
    public void createMember(){
        MemberDto memberDto = new MemberDto("u1","1234","u1@test.com");

        memberService.create(memberDto);

        MemberDto found = memberService.findById(1L);

        assertThat(found.getMemberName()).isEqualTo(memberDto.getMemberName());
        assertThat(found.getEmail()).isEqualTo(memberDto.getEmail());
        assertThat(found.getPassword()).isEqualTo(memberDto.getPassword());
    }
}
