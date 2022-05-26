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

import java.util.List;
import java.util.stream.Collectors;

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

        OrderNo orderNo = this.orderNoRepository.nextOrderNo();
        Orderer orderer = this.ordererRepository.findByUsername(placeOrder.getUsername());

        //
        OrderProducts orderProducts = this.orderProductRepository.findByProductIds(placeOrder.getOrderProductIds());

        List<OrderLine> orderLines = placeOrder.getOrderLineRequests().stream()
                .map( m ->
                        OrderLine.builder()
                            .orderNo(orderNo)
                            .product(orderProducts.getOrderProduct(m.getProductId()))
                            .quantity(m.getQuantity()).build()
                    ).collect(Collectors.toList());

        final Order order = Order.builder()
                .orderer(orderer)
                .orderNo(orderNo)
                .orderLines(orderLines)
                .shippingInformation(placeOrder.getShippingRequest().createShippingInformation()).build();

        final Order saved = this.orderRepository.save(order);

        return new OrderComplete(saved.getOrderNo().getOrderNo());
    }
}
