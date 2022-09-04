package com.example.LionKingJPA.domain.user.entity;

import com.example.LionKingJPA.global.common.BaseEntity;


import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;

@Entity
public class SiteUser extends BaseEntity {

    @Column(unique = true)
    private String email;

    private String password;

    @Column(unique = true)
    private String name;

    @Embedded
    @Column(nullable = false)
    private Address address;

}
