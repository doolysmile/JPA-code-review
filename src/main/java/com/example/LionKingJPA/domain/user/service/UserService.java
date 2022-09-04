package com.example.LionKingJPA.domain.user.service;

import com.example.LionKingJPA.domain.user.dto.UserDto;
import com.example.LionKingJPA.domain.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;


    public Long create(UserDto userDto){
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        return userRepository.save(UserDto.toEntity(userDto,
                passwordEncoder.encode(userDto.getPassword()))).getId();
    }
}
