package com.mysite.sbb.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class SiteUser {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique=true)//값을 중복되게 저장할 수 없음
    private String username;

    private String password;

    @Column(unique=true)
    private String email;
}
