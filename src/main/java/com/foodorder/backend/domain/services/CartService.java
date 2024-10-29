package com.foodorder.backend.domain.services;

import com.foodorder.backend.domain.model.Cart;
import com.foodorder.backend.domain.model.FoodCart;
import com.foodorder.backend.domain.model.SysUser;
import com.foodorder.backend.domain.providers.IdentityProvider;
import com.foodorder.backend.persistence.repository.FoodCartRepository;
import com.foodorder.backend.persistence.repository.FoodItemRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CartService {
    private final IdentityProvider identityProvider;
    private final FoodItemRepository foodItemRepository;
    private final FoodCartRepository foodCartRepository;

    // sysUser - > cartId , set cart id -> foodCart
    public Long addItemToCart(Long foodItemId, Long quantity) {
        SysUser sysUser = identityProvider.currentIdentity();
        Long cartId = sysUser.getCartId();

        if(foodItemRepository.getById(foodItemId).getQuantity() < quantity) {
            throw new RuntimeException("Not enough food to add to cart");
        }

        if(foodItemRepository.isExist(cartId, foodItemId))
        {
            return updateItemInCart(foodItemId, quantity);
        }

        FoodCart foodCart = FoodCart.builder()
                .createdAt(LocalDateTime.now())
                .foodItemId(foodItemId)
                .quantity(quantity)
                .cartId(cartId)
                .build();

      FoodCart savedFoodCart = foodCartRepository.save(foodCart);
       return savedFoodCart.getId();
    }

    public Long updateItemInCart(Long foodItemId, Long quantity) {
        SysUser sysUser = identityProvider.currentIdentity();
        Long cartId = sysUser.getCartId();

        if(foodItemRepository.getById(foodItemId).getQuantity() < quantity) {
            throw new RuntimeException("Not enough food to update item in cart");
        }

        return foodItemRepository.updateItemInCart(foodItemId, quantity, cartId);
    }

    public Long deleteItemFromCart(Long foodCartId) {
        foodCartRepository.deleteItemFromCart(foodCartId);
        return foodCartId;
    }

    public Long deleteAllItemFromCart() {// return number of deleted items
        Long number =  numberOfItemsInCart();

        foodCartRepository.deleteAllItemFromCart();
        return number;
    }

    public Long numberOfItemsInCart() {
        SysUser sysUser = identityProvider.currentIdentity();
        Long cartId = sysUser.getCartId();
        return foodCartRepository.numberOfItemsInCart(cartId);
    }

    public void deleteMultipleItemInCart(List<Long> ids) {
        foodCartRepository.deleteMultipleItemInCart(ids);
    }

    public List<FoodCart> getCartItems() {
        SysUser user = identityProvider.currentIdentity();
        Long cartId = user.getCartId();
        return foodCartRepository.getCartItems(cartId);
    }
}
