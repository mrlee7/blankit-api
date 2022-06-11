package com.blankit.api.domain.entity;

import lombok.Getter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Getter
public class MemberAuth {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "member_auth_id")
    private Long id;

    @Column(name = "auth_token")
    private String authToken;

    @Column(name = "created_date")
    private LocalDateTime createdDate;

    @Column(name = "modified_date")
    private LocalDateTime modifiedDate;

}
