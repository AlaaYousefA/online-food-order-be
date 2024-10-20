package com.foodorder.backend.domain.services;

import com.foodorder.backend.persistence.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class OrderService {
    final OrderRepository orderRepository;
}
