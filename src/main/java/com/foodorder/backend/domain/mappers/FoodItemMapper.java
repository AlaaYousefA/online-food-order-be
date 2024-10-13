package com.foodorder.backend.domain.mappers;

import com.foodorder.backend.application.dtos.food.CreateFoodItemRequest;
import com.foodorder.backend.application.dtos.food.CreateFoodItemResponse;
import com.foodorder.backend.domain.model.FoodItem;
import com.foodorder.backend.persistence.entity.FoodItemEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface FoodItemMapper {
    FoodItem createFoodItemRequestToModel(CreateFoodItemRequest createFoodItemRequest);

    @Mapping(target = "discount.id", source = "discountId")
    FoodItemEntity modelToEntity(FoodItem foodItem);

    @Mapping(target = "discountId", source = "discount.id")
    FoodItem EntityToModel(FoodItemEntity foodItemEntity);

    CreateFoodItemResponse modelToCreateFoodItemResponse(FoodItem foodItem);
}
