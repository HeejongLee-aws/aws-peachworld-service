package com.aws.peachworld.command.product.application;

import lombok.Getter;

@Getter
public class ProductRegisterCommand {

    private String name;

    private Long price;
}
