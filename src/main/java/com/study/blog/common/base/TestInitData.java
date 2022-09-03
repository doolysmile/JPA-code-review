package com.study.blog.common.base;

import com.study.blog.domain.member.domain.Member;
import com.study.blog.domain.member.repository.MemberRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.util.Arrays;

@Configuration
@Profile("test")
public class TestInitData {

    @Bean
    CommandLineRunner init(MemberRepository memberRepository){
        return args -> {
            Member m1 = Member.builder()
                    .memberName("u1")
                    .password("1234")
                    .email("e1@email.com")
                    .build();

            Member m2 = Member.builder()
                    .memberName("u2")
                    .password("1234")
                    .email("e2@email.com")
                    .build();

            Member m3 = Member.builder()
                    .memberName("u3")
                    .password("1234")
                    .email("e3@email.com")
                    .build();

            Member m4 = Member.builder()
                    .memberName("u4")
                    .password("1234")
                    .email("e4@email.com")
                    .build();

            Member m5 = Member.builder()
                    .memberName("u5")
                    .password("1234")
                    .email("e5@email.com")
                    .build();

            memberRepository.saveAll(Arrays.asList(m1,m2,m3,m4,m5));
        };
    }
}
