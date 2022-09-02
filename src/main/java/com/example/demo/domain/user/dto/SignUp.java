package com.example.demo.domain.user.dto;

import com.example.demo.domain.user.entity.SiteUser;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;

public class SignUp {
    @Getter
    @Setter
    public static class requestDto {
        @NotEmpty(message = "email은 필수항목입니다.")
        @Size(max = 50)
        @Email
        private String email;

        @NotEmpty(message = "비밀번호는 필수항목입니다.")
        @Size(max = 50)
        private String password;

        @NotEmpty(message = "비밀번호 확인은 필수항목입니다.")
        @Size(max = 50)
        private String passwordConfirm;

        @NotEmpty(message = "이름은 필수항목입니다.")
        @Size(max = 50)
        private String name;

        public SiteUser toEntity(){
            return SiteUser.builder()
                    .email(email)
                    .password(password)
                    .name(name)
                    .createdAt(LocalDateTime.now())
                    .updatedAt(LocalDateTime.now())
                    .build();
        }
    }

    @Getter
    @Setter
    public static class responseDto{
        private String email;

        private String name;

        public responseDto(SiteUser siteUser){
            this.email = siteUser.getEmail();
            this.name = siteUser.getName();
        }
    }
}
