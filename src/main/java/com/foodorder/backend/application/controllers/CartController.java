package com.foodorder.backend.application.controllers;

import com.foodorder.backend.domain.mappers.CartMapper;
import com.foodorder.backend.domain.services.CartService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/cart")
@RequiredArgsConstructor
public class CartController {
    private final CartService cartService;
    private final CartMapper cartMapper;

    @PutMapping
    public ResponseEntity<Long> addItemToCart(@RequestParam("foodItemId") Long foodItemId, @RequestParam("qauntity") Long quantity){
        return ResponseEntity.ok(cartService.addItemToCart(foodItemId, quantity));
    }

    @PutMapping("/update")
    public ResponseEntity<Long> updateItemInCart(@RequestParam("foodItemId") Long foodItemId, @RequestParam("qauntity") Long quantity){
        return ResponseEntity.ok(cartService.updateItemInCart(foodItemId, quantity));
    }

    @DeleteMapping // return deleted food Cart id
    public ResponseEntity<Long>




// deleteItem, deleteMultipleItems
// Indicates if items are still available
// private Boolean itemsAvailable;
// private Double totalPrice;
}
