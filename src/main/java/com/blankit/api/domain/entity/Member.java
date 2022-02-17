package com.blankit.api.domain.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
public class Member {

    @Id @GeneratedValue
    @Column(name = "member_id")
    private Long id;

    @OneToOne
    @JoinColumn(name = "member_auth_id")
    private MemberAuth memberAuth;

    @OneToOne
    @JoinColumn(name = "payment_info_id")
    private PaymentInfo paymentInfo;

    @Column(name = "email", nullable = false)
    private String email;

    @Column(name = "nickname", nullable = false)
    private String nickname;

}
