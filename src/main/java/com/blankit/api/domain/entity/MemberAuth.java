package com.blankit.api.domain.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.time.LocalDateTime;

@Entity
public class MemberAuth {

    @Id @GeneratedValue
    @Column(name = "member_auth_id")
    private Long id;

    @Column(name = "auth_token")
    private String authToken;

    @Column(name = "created_date")
    private LocalDateTime createdDate;

    @Column(name = "modified_date")
    private LocalDateTime modifiedDate;

}
