package com.aws.peachworld.view.port;

import com.aws.peachworld.view.application.readmodel.OrderHistory;

import java.util.List;

public interface OrderHistoryRepository {

    OrderHistory findByOrderNo(final Long orderNo);

    List<OrderHistory> findByUsername(final String username);

    OrderHistory save(OrderHistory orderHistory);
}
