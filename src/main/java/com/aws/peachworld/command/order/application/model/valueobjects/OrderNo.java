package com.aws.peachworld.command.order.application.model.valueobjects;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Builder
@Getter
@Embeddable
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode(of = "orderNo")
public class OrderNo implements Serializable {

    @Column(name = "order_no")
    private String orderNo;
}
