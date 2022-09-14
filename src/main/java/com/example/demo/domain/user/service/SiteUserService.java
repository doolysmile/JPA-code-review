package com.example.demo.domain.user.service;

import com.example.demo.domain.user.dto.SignUp;
import com.example.demo.domain.user.entity.SiteUser;
import com.example.demo.domain.user.repository.SiteUserRepository;
import com.example.demo.global.error.exception.PasswordsDifferentException;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class SiteUserService {
    private final SiteUserRepository siteUserRepository;
    private final PasswordEncoder passwordEncoder;

    public SignUp.responseDto signUp(SignUp.requestDto requestDto) throws PasswordsDifferentException{
        // 비밀번호 일치하지 않다면
        if(!requestDto.getPassword().equals(requestDto.getPasswordConfirm())){
            throw new PasswordsDifferentException("The passwords were different.");
        }

        // dto => entity
        SiteUser siteUser = requestDto.toEntity();
        // password encoding
        siteUser.changePassword(passwordEncoder.encode(siteUser.getPassword()));

        SiteUser saveSiteUser = siteUserRepository.save(siteUser);

        // entity => dto
        return new SignUp.responseDto(saveSiteUser);
    }
}
