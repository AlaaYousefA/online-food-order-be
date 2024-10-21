package com.foodorder.backend.application.controllers;

import com.foodorder.backend.domain.model.Order;
import com.foodorder.backend.domain.services.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/order")
@RequiredArgsConstructor
public class OrderController {
    private final OrderService orderService;

    @PostMapping
    public ResponseEntity<Order> placeOrder() { // RETURN STATE (ACCEPTED, DECLENED)
        return ResponseEntity.ok(orderService.placeOrder());
    }
    // private Boolean itemsAvailable;
    // place order
}
