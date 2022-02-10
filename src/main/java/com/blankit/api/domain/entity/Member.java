package com.blankit.api.domain.entity;

import javax.persistence.*;

@Entity
@Table(name = "MEMBERS")
public class Member {

    @Id
    @GeneratedValue
    @Column(name = "MEMBERS_ID")
    private Long id;
}
