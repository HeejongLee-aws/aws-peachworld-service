package com.aws.peachworld.command.order.port;

import com.aws.peachworld.command.order.application.model.valueobjects.OrderNo;

public interface OrderNoRepository {
    public OrderNo nextOrderNo();
}
