package com.foodorder.backend.domain.services;

import com.foodorder.backend.domain.model.FoodCart;
import com.foodorder.backend.domain.model.Order;
import com.foodorder.backend.domain.model.SysUser;
import com.foodorder.backend.domain.providers.IdentityProvider;
import com.foodorder.backend.persistence.repository.FoodCartRepository;
import com.foodorder.backend.persistence.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class OrderService {
    private final OrderRepository orderRepository;
    private final IdentityProvider identityProvider;
    private final CartService cartService;
    private final FoodCartRepository foodCartRepository;

    public Order placeOrder() {
        SysUser sysUser = identityProvider.currentIdentity();
        Long cartId = sysUser.getCartId();

        Order order = Order.builder()
                .createdAt(LocalDateTime.now())
                .cartId(cartId)
                .totalItems(cartService.numberOfItemsInCart())
                .totalPrice(calculateTotalPrice())
                .status(isItemsInCartAvailable())
                .build();

        if(!isItemsInCartAvailable()){
            throw new RuntimeException("items not available");
        }

        updateFoodItemsQuantityByOrder(order);

        return orderRepository.save(order);
    }

    public Double calculateTotalPrice() {
        SysUser sysUser = identityProvider.currentIdentity();
        Long cartId = sysUser.getCartId();

        return orderRepository.calculateTotalPrice(cartId);
    }

    public Boolean isItemsInCartAvailable(){
        SysUser sysUser = identityProvider.currentIdentity();
        Long cartId = sysUser.getCartId();

        return orderRepository.isItemsInCartAvailable(cartId);
    }

    public void updateFoodItemsQuantityByOrder(Order order) {
        orderRepository.updateFoodItemsQuantityByOrder(order);
    }
    // FUNCTION TO DO :
    // TEST cart controller & order controller & idm == finish the project ;)
}
