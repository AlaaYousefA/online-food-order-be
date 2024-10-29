package com.foodorder.backend.domain.mappers;

import com.foodorder.backend.domain.model.FoodCart;
import com.foodorder.backend.persistence.entity.FoodCartEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface FoodCartMapper {
    @Mapping(source = "cartId", target = "cart.id")
    @Mapping(source = "foodItemId", target = "foodItem.id")
    FoodCartEntity modelToEntity(FoodCart foodCart);


    @Mapping(source = "cart.id", target = "cartId")
    @Mapping(source = "foodItem.id", target = "foodItemId")
    FoodCart entityToModel(FoodCartEntity foodCartEntity);
}
