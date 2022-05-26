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
    public Orderer findByUsername(String username) throws NotExistOrdererException {
        Optional<Member> found = this.memberRepository.findByUsername(username);

        if ( found.isEmpty() ) {
            throw new NotExistOrdererException();
        }

        Member member = found.get();
        return new Orderer(member.getId(), member.getUsername(), member.getName());
    }


}