package com.foodorder.backend.domain.services;

import com.foodorder.backend.domain.model.Order;
import com.foodorder.backend.domain.model.SysUser;
import com.foodorder.backend.domain.providers.IdentityProvider;
import com.foodorder.backend.persistence.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class OrderService {
    private final OrderRepository orderRepository;
    private final IdentityProvider identityProvider;
    private final CartService cartService;

//    public Boolean placeOrder() {
//        SysUser sysUser = identityProvider.currentIdentity();
//        Long cartId = sysUser.getCartId();
//
//        Order order = Order.builder()
//                .createdAt(LocalDateTime.now())
//                .cartId(cartId)
//                .totalItems(cartService.numberOfItemsInCart(cartId))
//                .totalPrice()
//                .build();
//    }
    // FUNCTION TO DO :
    // total price count   FUNCTION
    // All Items Available FUNCTION & return which items are not available.

    // TEST cart controller & order controller == finish the project ;)
}
