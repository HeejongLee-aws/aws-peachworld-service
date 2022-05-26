package com.aws.peachworld.view.application.readmodel;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Entity
@Table(schema = "peachworld", name = "order_histories")
public class OrderHistory implements Serializable  {

    @Id @GeneratedValue
    private Long no;

    @Column(name = "order_no")
    private Long orderNo;

    @Column(name = "user_id")
    private String userId;

    @Column(name = "user_name")
    private String userName;

    @Column(name = "amount")
    private Long amount;

    @Column(name = "payment_method")
    private String paymentMethod;

}
