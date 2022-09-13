package com.example.LionKingJPA.domain.user.service;

import com.example.LionKingJPA.domain.user.dto.UserDto;
import com.example.LionKingJPA.domain.user.entity.SiteUser;
import com.example.LionKingJPA.domain.user.repository.UserRepository;
import com.example.LionKingJPA.global.exception.DataNotFoundException;
import lombok.RequiredArgsConstructor;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;


    public Long create(UserDto userDto){
        // TODO : bean을 못 찾음
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        return userRepository.save(UserDto.toEntity(userDto,
                passwordEncoder.encode(userDto.getPassword()))).getId();
    }

    public SiteUser getUserByEmail(String email){
        // orElseThrow()사용
        return userRepository.findByEmail(email).orElseThrow(() -> new DataNotFoundException("user not found"));
    }

}
