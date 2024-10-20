package com.foodorder.backend.persistence.adapter;

import com.foodorder.backend.domain.mappers.FoodCartMapper;
import com.foodorder.backend.domain.model.Cart;
import com.foodorder.backend.domain.model.FoodCart;
import com.foodorder.backend.domain.model.SysUser;
import com.foodorder.backend.persistence.jpa.FoodCartJpaRepository;
import com.foodorder.backend.persistence.repository.FoodCartRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class FoodCartAdapter implements FoodCartRepository {
    private final FoodCartJpaRepository foodCartJpaRepository;
    private final FoodCartMapper foodCartMapper;
    private final FoodCartRepository foodCartRepository;

    @Override
    public FoodCart save(FoodCart foodCart) {
        return foodCartMapper.entityToModel(foodCartJpaRepository.save(foodCartMapper.modelToEntity(foodCart)));
    }

    @Override
    public void deleteItemFromCart(Long foodItemId) {
        foodCartJpaRepository.deleteById(foodItemId);
    }

    @Override
    public Long numberOfItemsInCart(Long cartId) {
        return foodCartJpaRepository.countFoodCartItems(cartId);
    }

    @Override
    public void deleteAllItemFromCart() {
      foodCartJpaRepository.deleteAll();
    }

    @Override
    public Cart getCart(SysUser sysUser) {
        return foodCartRepository.getCart(sysUser);
    }

    @Override
    public void deleteMultipleItemInCart(List<Long> ids) {
         foodCartJpaRepository.deleteAllById(ids);
    }
}
