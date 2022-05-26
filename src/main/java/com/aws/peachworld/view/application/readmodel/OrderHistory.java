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

    @Column(name = "member_id")
    private Long memberId;

    @Column(name = "username")
    private String username;

    @Column(name = "amount")
    private Long amount;

    @Column(name = "payment_method")
    private String paymentMethod;

    @Column(name = "payment_status")
    private String paymentStatus;

    @Column(name = "harvest_status")
    private String harvestStatus;

    @Column(name = "ship_status")
    private String shipStatus;
}
