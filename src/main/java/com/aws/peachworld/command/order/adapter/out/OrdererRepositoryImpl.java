package com.aws.peachworld.command.order.adapter.out;

import com.aws.peachworld.command.member.application.model.Member;
import com.aws.peachworld.command.member.port.MemberRepository;
import com.aws.peachworld.command.order.application.NotExistOrdererException;
import com.aws.peachworld.command.order.application.model.valueobjects.Orderer;
import com.aws.peachworld.command.order.port.OrdererRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@AllArgsConstructor
@Repository
public class OrdererRepositoryImpl implements OrdererRepository {

    private MemberRepository memberRepository;

    @Override
    public Optional<Orderer> findByUsername(String username) {
        Optional<Member> found = this.memberRepository.findByUsername(username);

        if ( found.isEmpty() ) {
            return Optional.empty();
        }

        Member member = found.get();
        return Optional.of(new Orderer(member.getId(), member.getUsername(), member.getName()));
    }


}