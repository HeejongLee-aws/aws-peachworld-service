package com.aws.peachworld.command.product.application;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class RegisterComplete {

    private Long productId;

    private String productName;

    private Long productPrice;
}
