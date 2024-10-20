package com.foodorder.backend.persistence.repository;

import com.foodorder.backend.domain.model.Cart;
import com.foodorder.backend.domain.model.FoodCart;
import com.foodorder.backend.domain.model.SysUser;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FoodCartRepository {

    FoodCart save(FoodCart foodCart);

    void deleteItemFromCart(Long foodItemId);

    Long numberOfItemsInCart();

    void deleteAllItemFromCart();

    Cart getCart(SysUser sysUser);

    void deleteMultipleItemInCart(List<Long> ids);
}
