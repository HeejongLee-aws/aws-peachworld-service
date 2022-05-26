package com.aws.peachworld.view.application;

import com.aws.peachworld.view.application.readmodel.OrderHistory;
import com.aws.peachworld.view.port.OrderHistoryRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@AllArgsConstructor
public class UpdateOrderHistory {

    private OrderHistoryRepository orderHistoryRepository;

    @Transactional
    public void save(OrderHistory orderHistory){
        this.orderHistoryRepository.save(orderHistory);
    }
}
