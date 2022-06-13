package com.blankit.api.domain.entity.payment;

import lombok.Getter;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Getter
@Inheritance(strategy = InheritanceType.JOINED)
@DiscriminatorColumn(name = "payment_type")
public class Payment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "payment_id")
    private Long id;

    @Column(name = "payment_date")
    private LocalDateTime paymentDate;

    @Column(name = "payment_key")
    private String paymentKey;

    @OneToMany(mappedBy = "payment")
    private List<PaymentHistory> paymentInfoHistories;

}
