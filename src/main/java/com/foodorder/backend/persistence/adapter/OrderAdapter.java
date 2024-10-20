package com.foodorder.backend.persistence.adapter;

import com.foodorder.backend.persistence.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class OrderAdapter implements OrderRepository {
}
