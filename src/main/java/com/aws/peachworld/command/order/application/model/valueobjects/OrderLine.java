package com.aws.peachworld.command.order.application.model.valueobjects;

import lombok.*;

import javax.persistence.*;

@Builder
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@ToString
@Table(schema = "peachworld", name = "order_lines")
public class OrderLine {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Embedded
    private OrderNo orderNo;

    @Embedded
    private OrderProduct product;

    @Column(name = "quantity")
    private int quantity;
}