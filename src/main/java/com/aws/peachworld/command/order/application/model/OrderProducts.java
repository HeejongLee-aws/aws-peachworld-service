package com.aws.peachworld.command.order.application.model;


import com.aws.peachworld.command.order.application.model.valueobjects.OrderProduct;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class OrderProducts {
    private Map<Long, OrderProduct> orderLineProducts = new HashMap<Long, OrderProduct>();
    public OrderProduct getOrderProduct(final Long productId) {
        return this.orderLineProducts.get(productId);
    }

    public void add(Long productId, String productName, Long price){
        this.orderLineProducts.put(productId,
                new OrderProduct(productId, productName, price));
    }

    public void add(List<OrderProduct> orderProductList) {
        orderProductList.forEach( item -> {

        });
    }
}
