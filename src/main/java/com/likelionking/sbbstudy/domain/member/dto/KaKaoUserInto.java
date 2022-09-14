package com.likelionking.sbbstudy.domain.member.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class KaKaoUserInto {
    private Long id;
    private String nickname;
    private String email;
}
