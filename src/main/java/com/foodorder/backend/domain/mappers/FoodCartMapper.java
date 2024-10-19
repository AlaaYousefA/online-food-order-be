package com.foodorder.backend.domain.mappers;

import com.foodorder.backend.domain.model.FoodCart;
import com.foodorder.backend.persistence.entity.FoodCartEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface FoodCartMapper {
    FoodCartEntity modelToEntity(FoodCart foodCart);
    FoodCart entityToModel(FoodCartEntity foodCartEntity);
}
