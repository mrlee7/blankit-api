package com.blankit.api.domain.entity;

import com.blankit.api.domain.entity.payment.Payment;
import lombok.Getter;

import javax.persistence.*;

@Entity
@Getter
public class Member {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "MEMBER_ID")
    private Long id;

    @OneToOne
    @JoinColumn(name = "MEMBER_AUTH_ID", foreignKey = @ForeignKey(name = "FK_MEMBER_MEMBER_AUTH"))
    private MemberAuth memberAuth;

    @OneToOne
    @JoinColumn(name = "PAYMENT_ID", foreignKey = @ForeignKey(name = "FK_MEMBER_PAYMENT"))
    private Payment payment;

    @Column(name = "EMAIL", nullable = false)
    private String email;

    @Column(name = "NICKNAME", nullable = false)
    private String nickname;

}
