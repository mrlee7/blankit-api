package com.blankit.api.domain.entity;

import lombok.Getter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Getter
public class MemberAuth {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "MEMBER_AUTH_ID")
    private Long id;

    @Column(name = "AUTH_TOKEN")
    private String authToken;

    @Column(name = "CREATED_DATE")
    private LocalDateTime createdDate;

    @Column(name = "MODIFIED_DATE")
    private LocalDateTime modifiedDate;

}
