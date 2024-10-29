package com.foodorder.backend.persistence.repository;

import com.foodorder.backend.domain.model.FoodItem;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FoodItemRepository {
    FoodItem createFoodItem(FoodItem foodItem);

    void updateFoodItemById(Long id, FoodItem foodItem);

    FoodItem getById(Long id);

    Page<FoodItem> getAllFoodItems(int page, int size, String sortBy, String sortDirection);

    void deleteFoodItem(Long id);

    void deleteMultipleFoodItems(List<Long> ids);

    Long updateItemInCart(Long foodItemId, Long quantity, Long cartId);

    boolean isExist(Long cartId, Long foodItemId);
}
