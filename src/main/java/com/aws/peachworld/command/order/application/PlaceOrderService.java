package com.aws.peachworld.command.order.application;

import com.aws.peachworld.command.order.application.model.Order;
import com.aws.peachworld.command.order.application.model.OrderProducts;
import com.aws.peachworld.command.order.application.model.valueobjects.*;
import com.aws.peachworld.command.order.port.OrderNoRepository;
import com.aws.peachworld.command.order.port.OrderProductRepository;
import com.aws.peachworld.command.order.port.OrderRepository;
import com.aws.peachworld.command.order.port.OrdererRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.Optional;

@Slf4j
@Service
@AllArgsConstructor
public class PlaceOrderService {

    private final OrderRepository  orderRepository;

    private final OrdererRepository ordererRepository;

    private final OrderProductRepository orderProductRepository;

    private final OrderNoRepository orderNoRepository;

    @Transactional(transactionManager = "transactionManager")
    public OrderComplete placeOrder(PlaceOrder placeOrder) throws NotExistOrdererException {

        Optional<Orderer> orderer = this.ordererRepository.findByUsername(placeOrder.getUsername());

        if(orderer.isEmpty()){
            throw new NotExistOrdererException();
        }

        // SAGA

        final OrderNo orderNo = this.orderNoRepository.nextOrderNo();
        final OrderProducts orderProducts = this.orderProductRepository.findByProductIds(placeOrder.getOrderProductIds());

        final Order order = placeOrder.createOrder(orderNo, orderer.get(), orderProducts);
        final Order saved = this.orderRepository.save(order);

        return new OrderComplete(saved.getOrderNo().getOrderNo());
    }
}
