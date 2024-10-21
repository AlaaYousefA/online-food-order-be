package com.foodorder.backend.persistence.repository;

import com.foodorder.backend.domain.model.Order;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository {
    Double calculateTotalPrice(Long cartId);

    Order save(Order order);

    Boolean isItemsInCartAvailable(Long cartId);

    void updateFoodItemsQuantityByOrder(Order order);
}
