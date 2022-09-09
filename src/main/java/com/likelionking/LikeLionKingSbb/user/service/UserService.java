package com.likelionking.LikeLionKingSbb.user.service;

import com.likelionking.LikeLionKingSbb.exception.DataNotFoundException;
import com.likelionking.LikeLionKingSbb.user.domain.SiteUser;
import com.likelionking.LikeLionKingSbb.user.dto.UserDto;
import com.likelionking.LikeLionKingSbb.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public long create(UserDto userDto) {
        // TODO: 비밀번호 bcrypt 암호화 여기서 하는게 맞는지
        userDto.setPassword(passwordEncoder.encode(userDto.getPassword()));

        SiteUser siteUser = userDto.toEntity(userDto);
        SiteUser savedUser = userRepository.save(siteUser);

        return savedUser.getId();
    }

    public SiteUser findById(long id) {
        return userRepository.findById(id).orElseThrow(() -> {
            throw new DataNotFoundException("user not found");
        });
    }

    public SiteUser findByUsername(String username) {
        return userRepository.findByUsername(username).orElseThrow(() -> {
            throw new DataNotFoundException("user not found");
        });
    }
}
