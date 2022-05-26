package com.aws.peachworld.command.product.application;

import com.aws.peachworld.command.product.application.model.Product;
import com.aws.peachworld.command.product.port.ProductRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class ProductRegisterService {

    private final ProductRepository repository;

    public RegisterComplete register(ProductRegisterCommand command) throws  AlreadyRegisteredProductException{

        final Optional<Product> found = this.repository.findByName(command.getName());

        if( found.isPresent()){
            throw new AlreadyRegisteredProductException();
        }

        final Product product = Product.builder()
                .name(command.getName())
                .price(command.getPrice())
                .build();

        final Product saved = this.repository.save(product);

        RegisterComplete registerComplete = new RegisterComplete(saved.getId(), saved.getName(), saved.getPrice());

        return registerComplete;
    }
}
