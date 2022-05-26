package com.aws.peachworld.command.order.adapter.out;

import com.aws.peachworld.command.order.application.model.valueobjects.OrderNo;
import com.aws.peachworld.command.order.port.OrderNoRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.concurrent.ThreadLocalRandom;

@Repository
public class OrderNoRepositoryImpl implements OrderNoRepository {

    @Override
    public OrderNo nextOrderNo() {
        int randomNo = ThreadLocalRandom.current().nextInt(900000) + 100000;
        String number = String.format("%tY%<tm%<td%<tH-%d", new Date(), randomNo);
        return new OrderNo(number);
    }
}
