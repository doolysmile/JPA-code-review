package com.likelionking.LikeLionKingSbb.user.domain;


import lombok.*;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserCreateForm {
    @Size(min = 5, max = 20, message = "id는 5 ~ 20자리로 입력해주세요.")
    @NotEmpty(message = "id는 필수항목입니다.")
    private String username;

    @Size(min = 8, max = 16, message = "비밀번호는 8 ~ 16자리로 입력해주세요.")
    @NotEmpty(message = "비밀번호는 필수항목입니다.")
    private String password1;

    @Size(min = 8, max = 16, message = "비밀번호는 8 ~ 16자리로 입력해주세요.")
    @NotEmpty(message = "비밀번호 확인은 필수항목입니다.")
    private String password2;

    @Email(message = "이메일 형식이 올바르지 않습니다.")
    @NotEmpty(message = "이메일은 필수항목입니다.")
    private String email;

    public static SiteUser toEntity(UserCreateForm userCreateForm) {
        return SiteUser.builder()
                .username(userCreateForm.getUsername())
                .password(userCreateForm.getPassword2())
                .email(userCreateForm.getEmail())
                .build();
    }
}
