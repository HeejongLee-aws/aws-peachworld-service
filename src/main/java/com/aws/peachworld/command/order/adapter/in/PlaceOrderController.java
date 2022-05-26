package com.aws.peachworld.command.order.adapter.in;

import com.aws.peachworld.command.order.application.NotExistOrdererException;
import com.aws.peachworld.command.order.application.OrderComplete;
import com.aws.peachworld.command.order.application.PlaceOrderService;
import com.aws.peachworld.command.order.application.PlaceOrder;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class PlaceOrderController {

    private PlaceOrderService service;

    public PlaceOrderController(PlaceOrderService service) {
        this.service = service;
    }

    @PostMapping("/order")
    public ResponseEntity<OrderComplete> placeOrder(@RequestBody PlaceOrder command) {

        try {
            final OrderComplete orderComplete = this.service.placeOrder(command);
            return ResponseEntity.ok(orderComplete);
        }catch (NotExistOrdererException exception) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}



