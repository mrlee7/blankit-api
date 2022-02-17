package com.blankit.api.domain.entity;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
public class PaymentInfo {

    @Id
    @GeneratedValue
    @Column(name = "payment_info_id")
    private Long id;

    @Column
    private Integer amount;

    @Enumerated(EnumType.STRING)
    private PaymentType paymentType;

    @Column
    private LocalDateTime paymentDate;

    @Column
    private String paymentKey;

    @Column
    private String paymentId;

}
