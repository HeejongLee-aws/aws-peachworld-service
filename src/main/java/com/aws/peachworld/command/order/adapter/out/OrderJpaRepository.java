package com.aws.peachworld.command.order.adapter.out;

import com.aws.peachworld.command.order.application.model.Order;
import com.aws.peachworld.command.order.port.OrderRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderJpaRepository extends OrderRepository, JpaRepository<Order, Long> {
}
