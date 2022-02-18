package com.blankit.api.domain.entity.payment;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Getter
@Setter
@Inheritance(strategy = InheritanceType.JOINED)
@DiscriminatorColumn(name = "payment_type")
public class PaymentInfo {

    @Id
    @GeneratedValue
    private Long id;

    @Column(name = "payment_date")
    private LocalDateTime paymentDate;

    @Column(name = "payment_key")
    private String paymentKey;

    @Column(name = "payment_id")
    private String paymentId;

    @OneToMany(mappedBy = "paymentInfo")
    private List<PaymentInfoHistory> paymentInfoHistories;

}
