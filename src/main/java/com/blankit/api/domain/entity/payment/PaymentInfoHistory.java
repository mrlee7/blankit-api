package com.blankit.api.domain.entity.payment;

import com.blankit.api.domain.entity.payment.PaymentInfo;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
public class PaymentInfoHistory {

    @Id @GeneratedValue
    private Long id;

    @ManyToOne
    @JoinColumn(name = "payment_info_id")
    private PaymentInfo paymentInfo;

    @Column(name = "payment_id")
    private Long paymentId;

    @Column(name = "created_date")
    private LocalDateTime createdDate;

    @Column(name = "modified_date")
    private LocalDateTime modifiedDate;

}
