package com.aws.peachworld.command.order.adapter.out;

import com.aws.peachworld.command.order.application.model.OrderProducts;
import com.aws.peachworld.command.order.port.OrderProductRepository;
import com.aws.peachworld.command.product.application.model.Product;
import com.aws.peachworld.command.product.port.ProductRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;
import java.util.List;

@AllArgsConstructor
@Repository
public class OrderProductRepositoryImpl implements OrderProductRepository {

    private ProductRepository productRepository;

    @Override
    public OrderProducts findByProductIds(List<Long> orderProductIds) {
        List<Product> products = this.productRepository.findByIdIn(orderProductIds);
        OrderProducts orderProducts = new OrderProducts();

        for (Product item : products) {
            orderProducts.add(item.getId(), item.getName(), item.getPrice());
        }

        return orderProducts;
    }
}