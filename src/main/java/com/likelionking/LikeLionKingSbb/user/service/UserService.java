package com.likelionking.LikeLionKingSbb.user.service;

import com.likelionking.LikeLionKingSbb.exception.DataNotFoundException;
import com.likelionking.LikeLionKingSbb.user.domain.SiteUser;
import com.likelionking.LikeLionKingSbb.user.domain.UserCreateForm;
import com.likelionking.LikeLionKingSbb.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;

    public long create(UserCreateForm userCreateForm) {
        SiteUser siteUser = UserCreateForm.toEntity(userCreateForm);
        SiteUser savedUser = userRepository.save(siteUser);

        return savedUser.getId();
    }

    public SiteUser findById(long id) {
        return userRepository.findById(id).orElseThrow(() -> {
            throw new DataNotFoundException("user not found");
        });
    }
}
