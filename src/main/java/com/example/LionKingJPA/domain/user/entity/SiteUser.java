package com.example.LionKingJPA.domain.user.entity;

import com.example.LionKingJPA.global.common.BaseEntity;
import lombok.*;


import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;

@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class SiteUser extends BaseEntity {

    @Column(unique = true)
    private String email;

    @Column()
    private String password;

    @Column()
    private String name;

    @Embedded
    @Column()
    private Address address;

}
