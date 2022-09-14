package com.example.demo.domain.user.dto;

import com.example.demo.domain.user.entity.SiteUser;
import com.example.demo.global.common.embedded.Address;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.persistence.Column;
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

        private String city;

        private String street;

        private String zipCode;
        public SiteUser toEntity(){
            Address address = Address.builder()
                    .city(city)
                    .street(street)
                    .zipCode(zipCode)
                    .build();

            return SiteUser.builder()
                    .email(email)
                    .password(password)
                    .name(name)
                    .address(address)
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
