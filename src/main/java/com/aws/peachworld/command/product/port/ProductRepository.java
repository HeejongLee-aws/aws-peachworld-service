package com.aws.peachworld.command.product.port;

import com.aws.peachworld.command.product.application.model.Product;

import java.util.List;
import java.util.Optional;

public interface ProductRepository {
    Product save(Product product);
    List<Product> findByIdIn(List<Long> ids);
    Optional<Product> findByName(final String name);
    Optional<Product> findById(final Long id);
}
