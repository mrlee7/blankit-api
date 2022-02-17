package com.blankit.api.domain.entity;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
public class PaymentInfoHistory {

    @Id @GeneratedValue
    @Column(name = "payment_history_id")
    private Long id;

    @Column(name = "payment_id")
    private Long paymentId;

    @Column(name = "created_date")
    private LocalDateTime createdDate;

    @Column(name = "modified_date")
    private LocalDateTime modifiedDate;

}
