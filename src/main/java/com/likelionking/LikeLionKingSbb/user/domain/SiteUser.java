package com.likelionking.LikeLionKingSbb.user.domain;

import com.likelionking.LikeLionKingSbb.common.BaseEntity;
import lombok.*;

import javax.persistence.*;

@Entity
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class SiteUser extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    private String username;    // id

    private String password;

    @Column(unique = true)
    private String email;
}
