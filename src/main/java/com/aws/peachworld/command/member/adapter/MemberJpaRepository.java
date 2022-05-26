package com.aws.peachworld.command.member.adapter;

import com.aws.peachworld.command.member.application.model.Member;
import com.aws.peachworld.command.member.port.MemberRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MemberJpaRepository extends MemberRepository, JpaRepository<Member, Long> {
}