package com.aws.peachworld.view.adapter;

import com.aws.peachworld.view.application.OrderHistoryQueryService;
import com.aws.peachworld.view.application.readmodel.OrderHistory;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
public class OrderHistoryController {

    private OrderHistoryQueryService orderHistoryQuery;

    @GetMapping("/orderhistory/users/{userId}")
    public ResponseEntity<List<OrderHistory>> findByUserId(@PathVariable final String userId) {
        List<OrderHistory> orderHistories = this.orderHistoryQuery.findByUsername(userId);
        return ResponseEntity.ok(orderHistories);
    }

    @GetMapping("/orderhistory/orders/{orderNo}")
    public ResponseEntity<OrderHistory> findByOrderNo(@PathVariable final Long orderNo) {
        OrderHistory orderHistory = this.orderHistoryQuery.findByOrderNo(orderNo);
        return ResponseEntity.ok(orderHistory);
    }
}