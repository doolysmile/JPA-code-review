package com.study.blog.domain.member.domain.dto;


import lombok.Builder;
import lombok.Getter;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Getter
@Builder
public class MemberCreateForm {
    @NotEmpty(message="사용자명을 입력해주세요")
    private String memberName;
    @NotEmpty(message="비밀번호를 입력해주세요.")
    private String password1;
    @NotEmpty(message = "비밀번호 확인은 필수항목입니다.")
    private String password2;
    @NotEmpty(message="이메일을 입력해주세요")
    private String email;

    public MemberDto toDto(){
        MemberDto  memberDto = MemberDto.builder()
                .email(this.email)
                .memberName(this.memberName)
                .password(this.password1)
                .build();
        return memberDto;
    }
}
