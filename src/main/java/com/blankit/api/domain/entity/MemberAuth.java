package com.blankit.api.domain.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
public class MemberAuth {

    @Id @GeneratedValue
    @Column(name = "MEMBER_AUTH_ID")
    private Long id;

    @Column(name = "AUTH_TOKEN")
    private String authToken;

    @Column(name = "CREATED_DATE")
    private LocalDateTime createdDate;

    @Column(name = "MODIFIED_DATE")
    private LocalDateTime modifiedDate;

}
