package com.aws.peachworld.command.member.application;

import com.aws.peachworld.command.member.application.model.Member;
import com.aws.peachworld.command.member.port.MemberRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Slf4j
@AllArgsConstructor
@Service
public class MemberSignUpService {

    private final MemberRepository repository;

    public SignUpComplete signUp(MemberSignUp command) throws MemberAlreadyExistException {

        final String username = command.getUsername();
        Optional<Member> found = this.repository.findByUsername(username);

        if( found.isPresent() ){
            log.info("already member {}", command.getUsername());
            throw new MemberAlreadyExistException();
        }

        Member member = Member.builder()
                .username(command.getUsername())
                .name(command.getName())
                .password((command.getPassword()))
                .telephoneNumber(command.getTelephoneNumber())
                .address1(command.getAddress1())
                .address2(command.getAddress2())
                .city(command.getCity())
                .build();

        Member saved = this.repository.save(member);
        return new SignUpComplete(saved.getId(), saved.getUsername());
    }
}
