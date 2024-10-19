package com.foodorder.backend.domain.services;


import com.foodorder.backend.domain.model.FoodItem;
import com.foodorder.backend.persistence.repository.FoodItemRepository;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class FoodItemService {
    private final FoodItemRepository foodItemRepository;

    public FoodItem createFoodItem(FoodItem foodItem) {
        foodItem.setCreatedAt(LocalDateTime.now());
        foodItem.setUpdatedAt(LocalDateTime.now());
        return foodItemRepository.createFoodItem(foodItem);
    }

    public FoodItem updateFoodItem(Long id, FoodItem foodItem) {
         foodItemRepository.updateFoodItemById(id, foodItem);
         return foodItemRepository.getById(id);
    }

    public FoodItem getFoodItem(Long id) {
        return foodItemRepository.getById(id);
    }

    public Page<FoodItem> getAllFoodItems(int page, int size, String sortBy, String sortDirection) {
        return foodItemRepository.getAllFoodItems(page, size, sortBy, sortDirection);
    }

    public Long deleteFoodItem(Long id) {
        if(foodItemRepository.getById(id) != null) {
            foodItemRepository.deleteFoodItem(id);
        }
        return id;
    }

    public void deleteMultipleFoodItems(List<Long> ids) {
        foodItemRepository.deleteMultipleFoodItems(ids);
    }


//    @Scheduled(cron = "0/5 * * ? * * ")
//    public void test(){
//        log.info("test is running");
//    }
}
