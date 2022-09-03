package com.study.blog.domain.member.domain.dto;

import com.study.blog.domain.member.domain.Member;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@AllArgsConstructor
public class MemberDto {
    private String memberName;
    private String password;
    private String email;

    public Member toEntity(){
        Member member = Member.builder()
                .email(email)
                .password(password)
                .memberName(memberName)
                .build();
        return member;
    }
}
