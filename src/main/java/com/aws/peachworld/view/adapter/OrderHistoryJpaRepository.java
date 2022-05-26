package com.aws.peachworld.view.adapter;

import com.aws.peachworld.view.application.readmodel.OrderHistory;
import com.aws.peachworld.view.port.OrderHistoryRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderHistoryJpaRepository extends OrderHistoryRepository, JpaRepository<OrderHistory, Long> {
}
