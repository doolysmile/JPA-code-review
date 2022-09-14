package com.likelionking.sbbstudy.domain.member.dto;

import com.likelionking.sbbstudy.domain.member.entity.Member;
import lombok.*;
import org.springframework.stereotype.Service;

import javax.persistence.Column;

@Getter
@Setter
@Builder
@AllArgsConstructor
public class MemberDto {

    private String nickname;

    private String email;


    public static MemberDto fromEntity(Member member){
        return MemberDto.builder()
                .nickname(member.getNickname())
                .email(member.getEmail())
                .build();

    }

}
