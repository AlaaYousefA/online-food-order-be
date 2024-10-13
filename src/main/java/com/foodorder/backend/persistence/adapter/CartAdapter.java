package com.foodorder.backend.persistence.adapter;

import com.foodorder.backend.persistence.jpa.CartJpaRepository;
import com.foodorder.backend.persistence.repository.CartRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class CartAdapter implements CartRepository {
    private final CartJpaRepository cartJpaRepository;


}
