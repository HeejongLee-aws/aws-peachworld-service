package com.aws.peachworld.command.product.adpater;

import com.aws.peachworld.command.product.application.model.Product;
import com.aws.peachworld.command.product.port.ProductRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductJpaRepository extends ProductRepository, JpaRepository<Product, Long> {
}
