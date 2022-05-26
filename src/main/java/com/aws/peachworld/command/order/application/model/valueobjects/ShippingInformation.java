package com.aws.peachworld.command.order.application.model.valueobjects;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Embeddable
public class ShippingInformation {

    @Column(name = "city")
    private String city;

    @Column(name = "telephoneNumber")
    private String telephoneNumber;

    @Column(name = "receiver")
    private String receiver;

    @Column(name = "address1")
    private String address1;

    @Column(name = "address2")
    private String address2;
}