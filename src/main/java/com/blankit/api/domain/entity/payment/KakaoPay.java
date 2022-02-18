package com.blankit.api.domain.entity.payment;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
@Getter
@Setter
public class KakaoPay extends PaymentInfo{

    @Column
    private String column1;

}
