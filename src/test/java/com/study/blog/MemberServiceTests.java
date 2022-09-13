package com.study.blog;

import com.study.blog.domain.member.domain.dto.MemberDto;
import com.study.blog.domain.member.service.MemberService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.transaction.annotation.Transactional;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@Transactional
@ActiveProfiles("test")
public class MemberServiceTests {
    @Autowired
    MemberService memberService;

    @Test
    @DisplayName("memberName이 u1, email이 u1@test.com, 비밀번호가 1234인 u1 멤버 생성")
    public void t1(){
        MemberDto memberDto = new MemberDto("u1","1234","u1@test.com");

        memberService.create(memberDto);

        MemberDto found = memberService.findById(6L);

        assertThat(found.getMemberName()).isEqualTo(memberDto.getMemberName());
        assertThat(found.getEmail()).isEqualTo(memberDto.getEmail());
        assertThat(found.getPassword()).isEqualTo(memberDto.getPassword());
    }

    @Test
    @DisplayName("TestInitData로 테스트 데이터 세팅")
    public void t2(){
        long count = memberService.memberCount();

        assertThat(count).isEqualTo(5L);
    }
}
