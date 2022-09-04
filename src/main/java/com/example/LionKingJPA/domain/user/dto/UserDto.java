package com.example.LionKingJPA.domain.user.dto;

import com.example.LionKingJPA.domain.user.entity.Address;
import com.example.LionKingJPA.domain.user.entity.SiteUser;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Embedded;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserDto {

    @NotEmpty(message = "이메일은 필수항목입니다.")
    @Email
    private String email;

    @NotEmpty(message = "비밀번호는 필수항목입니다.")
    private String password;

    @NotEmpty(message = "이름은 필수항목입니다.")
    private String name;

    @NotEmpty(message = "비밀번호 확인은 필수항목입니다.")
    private String passwordCheck;

    @Embedded
    private Address address;

    public static SiteUser toEntity(UserDto userDto, String password){
        return SiteUser.builder()
                .email(userDto.getEmail())
                .password(password)
                .name(userDto.name)
                .build();
    }
}
