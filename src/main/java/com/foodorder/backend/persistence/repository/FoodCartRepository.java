package com.foodorder.backend.persistence.repository;

import com.foodorder.backend.domain.model.Cart;
import com.foodorder.backend.domain.model.FoodCart;
import com.foodorder.backend.domain.model.SysUser;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FoodCartRepository {

    FoodCart save(FoodCart foodCart);

    void deleteItemFromCart(Long foodCartId);

    Long numberOfItemsInCart(Long cartId);

    void deleteAllItemFromCart();

    void deleteMultipleItemInCart(List<Long> ids);

    List<FoodCart> getCartItems(Long cartId);
}
