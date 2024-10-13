package com.foodorder.backend.application.controllers;

import com.foodorder.backend.domain.services.CartService;
import com.foodorder.backend.persistence.entity.OrdersEntity;
import com.foodorder.backend.persistence.entity.SysUserEntity;
import jakarta.persistence.*;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/cart")
@RequiredArgsConstructor
public class CartController {
    private final CartService cartService;

    @PostMapping
    private ResponseEntity<>
//    // Indicates if items are still available
//    private Boolean itemsAvailable;
}
