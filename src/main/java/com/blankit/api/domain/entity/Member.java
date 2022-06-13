package com.blankit.api.domain.entity;

import com.blankit.api.domain.entity.payment.Payment;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Getter
@NoArgsConstructor
public class Member {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "member_id")
    private Long id;

    @OneToOne
    @JoinColumn(name = "member_auth_id", foreignKey = @ForeignKey(name = "FK_MEMBER_MEMBER_AUTH"))
    private MemberAuth memberAuth;

    @OneToOne
    @JoinColumn(name = "payment_id", foreignKey = @ForeignKey(name = "FK_MEMBER_PAYMENT"))
    private Payment payment;

    @Column(name = "email", nullable = false)
    private String email;

    @Column(name = "nickname", nullable = false)
    private String nickname;

    @Builder
    private Member(Long id, MemberAuth memberAuth, Payment payment, String email, String nickname) {
        this.id = id;
        this.memberAuth = memberAuth;
        this.payment = payment;
        this.email = email;
        this.nickname = nickname;
    }
}
