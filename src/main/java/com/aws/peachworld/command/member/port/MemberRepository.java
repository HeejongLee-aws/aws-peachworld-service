package com.aws.peachworld.command.member.port;

import com.aws.peachworld.command.member.application.model.Member;

import java.util.Optional;

public interface MemberRepository {
    public Member save(Member member);

    public Optional<Member> findByUsername(String username);

    public Optional<Member> findById(Long id);
}
