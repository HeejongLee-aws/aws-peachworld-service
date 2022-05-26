package com.aws.peachworld.command.order.application.model.valueobjects;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class OrderProduct {

    @Column(name = "order_product_id")
    private Long productId;

    @Column(name = "order_product_name")
    private String productName;

    @Column(name = "price")
    private Long price;
}
