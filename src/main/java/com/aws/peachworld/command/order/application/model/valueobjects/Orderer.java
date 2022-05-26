package com.aws.peachworld.command.order.application.model.valueobjects;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Orderer {

    @Column( name = "orderer_member_id")
    private Long memberId;

    @Column( name = "orderer_username")
    private String username;

    @Column( name = "orderer_name")
    private String name;

}
