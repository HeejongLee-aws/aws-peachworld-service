package com.aws.peachworld.command.product.application.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Entity
@Table(schema = "peachworld", name = "products")
public class Product {

    @Id @GeneratedValue
    private Long id;

    @Column(name = "product_name")
    private String name;

    @Column(name = "price")
    private Long price;

}
