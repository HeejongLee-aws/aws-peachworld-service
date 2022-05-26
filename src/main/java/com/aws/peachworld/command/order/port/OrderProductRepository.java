package com.aws.peachworld.command.order.port;

import com.aws.peachworld.command.order.application.model.OrderProducts;

import java.util.List;

public interface OrderProductRepository {

    public OrderProducts findByProductIds(List<Long> orderProductIds);
}
