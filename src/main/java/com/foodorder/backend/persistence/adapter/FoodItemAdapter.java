package com.foodorder.backend.persistence.adapter;

import com.foodorder.backend.domain.mappers.FoodItemMapper;
import com.foodorder.backend.domain.model.FoodItem;
import com.foodorder.backend.persistence.entity.FoodItemEntity;
import com.foodorder.backend.persistence.jpa.FoodItemJpaRepository;
import com.foodorder.backend.persistence.repository.FoodItemRepository;
import lombok.RequiredArgsConstructor;
import org.hibernate.query.SortDirection;
import org.springframework.data.domain.*;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class FoodItemAdapter implements FoodItemRepository {
    private final FoodItemJpaRepository foodItemJpaRepository;
    private final FoodItemMapper foodItemMapper;

    @Override
    public FoodItem createFoodItem(FoodItem foodItem) {
        FoodItemEntity foodItemEntity = foodItemMapper.modelToEntity(foodItem);

        return foodItemMapper.EntityToModel(foodItemJpaRepository.save(foodItemEntity));
    }

    @Override
    public void updateFoodItemById(Long id, FoodItem foodItem) {
        foodItemJpaRepository.updateFoodItem(id, LocalDateTime.now(), foodItemMapper.modelToEntity(foodItem));
    }

    @Override
    public FoodItem getById(Long id) {
        return foodItemMapper.EntityToModel(foodItemJpaRepository.findById(id).orElseThrow(
                () -> new RuntimeException("id not exists " + id)
        ));
    }

    @Override
    public Page<FoodItem> getAllFoodItems(int page, int size, String sortBy, String sortDirection) {
        Sort.Direction direction = Sort.Direction.fromString(sortDirection);
        Pageable pageable = PageRequest.of(page, size, Sort.by(direction, sortBy));

        Page<FoodItemEntity> foodItemEntities = foodItemJpaRepository.findAll(pageable);


        List<FoodItem> foodItems = foodItemEntities
                .stream()
                .map(foodItemMapper::EntityToModel)
                .toList();

        return new PageImpl<>(foodItems, pageable, foodItemEntities.getTotalElements());
    }

    @Override
    public void deleteFoodItem(Long id) {
         foodItemJpaRepository.deleteById(id);
    }

    @Override
    public void deleteMultipleFoodItems(List<Long> ids) {
        foodItemJpaRepository.deleteAllById(ids);
    }
}
