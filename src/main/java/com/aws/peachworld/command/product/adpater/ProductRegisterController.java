package com.aws.peachworld.command.product.adpater;

import com.aws.peachworld.command.product.application.AlreadyRegisteredProductException;
import com.aws.peachworld.command.product.application.ProductRegisterCommand;
import com.aws.peachworld.command.product.application.ProductRegisterService;
import com.aws.peachworld.command.product.application.RegisterComplete;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class ProductRegisterController {

    private ProductRegisterService service;

    public ProductRegisterController(ProductRegisterService service) {
        this.service = service;
    }

    @PostMapping("/product")
    public ResponseEntity<RegisterComplete> register(@RequestBody ProductRegisterCommand command) {

        try {
            RegisterComplete complete = this.service.register(command);
            log.info("register completed - product physical id {} | name {}", complete.getProductId(), complete.getProductName());
            return ResponseEntity.ok(complete);
        }catch(AlreadyRegisteredProductException exception) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}