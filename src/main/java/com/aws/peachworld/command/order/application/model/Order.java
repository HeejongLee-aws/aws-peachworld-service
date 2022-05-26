package com.aws.peachworld.command.order.application.model;

import com.aws.peachworld.command.order.application.model.valueobjects.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Entity
@Table(schema = "peachworld", name = "orders")
public class Order {

    @EmbeddedId
    private OrderNo orderNo;

    @Embedded
    private Orderer orderer;

    @Embedded
    private PaymentAmount paymentAmount;

    @Embedded
    private ShippingInformation shippingInformation;

    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "order_no")
    private List<OrderLine> orderLines;

}
