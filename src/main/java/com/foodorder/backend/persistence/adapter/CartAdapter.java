package com.foodorder.backend.persistence.adapter;

import com.foodorder.backend.domain.mappers.CartMapper;
import com.foodorder.backend.domain.model.Cart;
import com.foodorder.backend.persistence.jpa.CartJpaRepository;
import com.foodorder.backend.persistence.repository.CartRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class CartAdapter implements CartRepository {
    private final CartJpaRepository cartJpaRepository;
    private final CartMapper cartMapper;


    @Override
    public Cart save(Cart cart) {
        return cartMapper.entityToModel(cartJpaRepository.save(cartMapper.modelToEntity(cart)));
    }
}
