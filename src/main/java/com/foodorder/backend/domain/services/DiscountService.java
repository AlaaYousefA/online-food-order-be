package com.foodorder.backend.domain.services;

import com.foodorder.backend.domain.model.Discount;
import com.foodorder.backend.domain.model.FoodItem;
import com.foodorder.backend.persistence.repository.DiscountRepository;
import com.foodorder.backend.persistence.repository.FoodItemRepository;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class DiscountService {
    private final DiscountRepository discountRepository;
    private final FoodItemRepository foodItemRepository;

    public Discount createDiscount(Discount discount) {
        discount.setCreatedAt(LocalDateTime.now());
        discount.setUpdatedAt(LocalDateTime.now());

        return discountRepository.save(discount);
    }

    public Discount updateDiscount(Long id,Discount discount) {
        discountRepository.updateDiscountById(id, discount);
        return discountRepository.getById(id);
    }

    public Discount getDiscount(Long id) {
        return discountRepository.getById(id);
    }

    public Page<Discount> getAllDiscounts(int page, int size, String sortBy, String sortDirection) {
        return discountRepository.getAllDiscounts(page, size, sortBy, sortDirection);
    }


    public List<Long> updateFoodItemsDiscounts(List<Long> ids, Long discountId) {
        List<Long> updatedFoodItemsId = new ArrayList<>();

        for (Long id : ids) {
            FoodItem foodItem = foodItemRepository.getById(id);
            foodItem.setDiscountId(discountId);
            foodItemRepository.updateFoodItemById(id, foodItem);
            updatedFoodItemsId.add(id);
        }
        return updatedFoodItemsId;
    }
}
