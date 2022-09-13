package com.study.blog;

import com.study.blog.domain.member.domain.Member;
import com.study.blog.domain.member.repository.MemberRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class MemberRepositoryTests {

    @Autowired
    MemberRepository memberRepository;

    @Test
    public void t1(){
        Member member = Member.builder()
                .memberName("user")
                .email("user1@asd.com")
                .password("1234")
                .build();

        memberRepository.save(member);

        Member user = memberRepository.findByMemberName("user").get();
        System.out.println(user.getMemberName());

    }
}
