package com.foodorder.backend.persistence.adapter;

import com.foodorder.backend.domain.mappers.OrderMapper;
import com.foodorder.backend.domain.model.Order;
import com.foodorder.backend.persistence.entity.OrdersEntity;
import com.foodorder.backend.persistence.jpa.OrderJpaRepository;
import com.foodorder.backend.persistence.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class OrderAdapter implements OrderRepository {
    private final OrderJpaRepository orderJpaRepository;
    private final OrderMapper orderMapper;

    @Override
    public Double calculateTotalPrice(Long cartId) {
        return orderJpaRepository.calculateTotalPrice(cartId);
    }

    @Override
    public Order save(Order order) {
        return orderMapper.entityToModel(orderJpaRepository.save(orderMapper.modelToEntity(order)));
    }

    @Override
    public Boolean isItemsInCartAvailable(Long cartId) {
        return orderJpaRepository.isItemsInCartAvailable(cartId);
    }

    @Override
    public void updateFoodItemsQuantityByOrder(Order order) {
        orderJpaRepository.updateFoodItemsQuantityByOrder(order.getCartId());
    }
}
