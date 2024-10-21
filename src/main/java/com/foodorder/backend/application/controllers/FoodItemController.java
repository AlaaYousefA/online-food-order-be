package com.foodorder.backend.application.controllers;

import com.foodorder.backend.application.dtos.food.CreateFoodItemRequest;
import com.foodorder.backend.application.dtos.food.CreateFoodItemResponse;
import com.foodorder.backend.domain.mappers.FoodItemMapper;
import com.foodorder.backend.domain.model.FoodItem;
import com.foodorder.backend.domain.services.FoodItemService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/food")
@RequiredArgsConstructor
public class FoodItemController {
    private final FoodItemService foodItemService;
    private final FoodItemMapper foodItemMapper;

    @PostMapping
    // @RolesAllowed({SystemRoleEnum.ADMIN.toString()})
    public ResponseEntity<CreateFoodItemResponse> createFoodItem(@RequestBody CreateFoodItemRequest Request) {
        FoodItem foodItem = foodItemMapper.createFoodItemRequestToModel(Request);
        return ResponseEntity.ok(foodItemMapper.modelToCreateFoodItemResponse(foodItemService.createFoodItem(foodItem)));
    }

    @GetMapping("/{id}")
    // @RolesAllowed({SystemRoleEnum.ADMIN.toString()})
    public ResponseEntity<FoodItem> getFoodItem(@PathVariable Long id) {
        return ResponseEntity.ok(
                foodItemService.getFoodItem(id)
        );
    }

    @GetMapping
    // @RolesAllowed({SystemRoleEnum.ADMIN.toString()})
    public ResponseEntity<Page<FoodItem>> getAllFoodItems(
            @RequestParam(name = "page", defaultValue = "0") int page,
            @RequestParam(name = "size", defaultValue = "10") int size,
            @RequestParam(name = "sortBy", defaultValue = "createdAt") String sortBy,
            @RequestParam(name = "sortDirection", defaultValue = "desc") String sortDirection

    ) {
        return ResponseEntity.ok(foodItemService.getAllFoodItems(page, size, sortBy, sortDirection));
    }

    @PutMapping("/{id}")
    // @RolesAllowed({SystemRoleEnum.ADMIN.toString()})
    public ResponseEntity<CreateFoodItemResponse> updateFoodItem(@PathVariable Long id, @RequestBody CreateFoodItemRequest Request) {
        FoodItem foodItem = foodItemMapper.createFoodItemRequestToModel(Request);
        return ResponseEntity.ok(foodItemMapper.modelToCreateFoodItemResponse(foodItemService.updateFoodItem(id, foodItem)));
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<Long> deleteFoodItem(@PathVariable Long id) {
        return ResponseEntity.ok(foodItemService.deleteFoodItem(id));
    }

    @DeleteMapping
    public ResponseEntity<Void> deleteMultipleFoodItems(@RequestBody List<Long> ids) {
        foodItemService.deleteMultipleFoodItems(ids);
        return ResponseEntity.ok().build();
    }
}
