package com.aws.peachworld.command.member.application;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Getter
public class MemberSignUp {
    private String username;

    private String password;

    private String name;

    private String address1;

    private String address2;

    private String city;

    private String telephoneNumber;
}
