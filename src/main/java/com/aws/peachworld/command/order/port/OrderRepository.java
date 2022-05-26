package com.aws.peachworld.command.order.port;

import com.aws.peachworld.command.order.application.model.Order;

public interface OrderRepository {

    public Order save(Order order);
}
