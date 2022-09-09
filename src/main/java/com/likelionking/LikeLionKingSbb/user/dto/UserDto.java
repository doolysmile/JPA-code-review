package com.likelionking.LikeLionKingSbb.user.dto;

import com.likelionking.LikeLionKingSbb.user.domain.SiteUser;
import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserDto {
    private Long id;
    private String username;
    private String password;
    private String email;

    public static SiteUser toEntity(UserDto userDto) {
        return SiteUser.builder()
                .username(userDto.getUsername())
                .password(userDto.getPassword())
                .email(userDto.getEmail())
                .build();
    }
}
