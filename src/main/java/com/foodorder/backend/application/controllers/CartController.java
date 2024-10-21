package com.foodorder.backend.application.controllers;

import com.foodorder.backend.domain.model.FoodCart;
import com.foodorder.backend.domain.services.CartService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/cart")
@RequiredArgsConstructor
public class CartController {
    private final CartService cartService;

    @PutMapping
    public ResponseEntity<Long> addItemToCart(@RequestParam("foodItemId") Long foodItemId, @RequestParam("qauntity") Long quantity){
        return ResponseEntity.ok(cartService.addItemToCart(foodItemId, quantity));
    }

    @PutMapping("/update")
    public ResponseEntity<Long> updateItemInCart(@RequestParam("foodItemId") Long foodItemId, @RequestParam("qauntity") Long quantity){
        return ResponseEntity.ok(cartService.updateItemInCart(foodItemId, quantity));
    }

    @GetMapping("/cart-items")
    public ResponseEntity<List<FoodCart>> getCartItems(){
        return ResponseEntity.ok(cartService.getCartItems());
    }

    @GetMapping("/total")
    public ResponseEntity<Long> getNumberOfItemsInCart(){
        return ResponseEntity.ok(cartService.numberOfItemsInCart());
    }

    @DeleteMapping ("/item")// return deleted food Cart id
    public ResponseEntity<Long> deleteItemFromCart(@RequestParam("foodItemId") Long foodItemId){
        return ResponseEntity.ok(cartService.deleteItemFromCart(foodItemId));
    }

    @DeleteMapping("/items")
    public ResponseEntity<Long> deleteAllItemFromCart(){ // return deleted items number
        return ResponseEntity.ok(cartService.deleteAllItemFromCart());
    }

    @DeleteMapping
    public ResponseEntity<Void> deleteMultipleItemInCart(@RequestBody List<Long> ids){
        cartService.deleteMultipleItemInCart(ids);
        return ResponseEntity.ok().build();
    }
}
