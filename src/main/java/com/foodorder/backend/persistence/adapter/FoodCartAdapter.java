package com.foodorder.backend.persistence.adapter;

import com.foodorder.backend.domain.mappers.FoodCartMapper;
import com.foodorder.backend.domain.model.FoodCart;
import com.foodorder.backend.persistence.jpa.FoodCartJpaRepository;
import com.foodorder.backend.persistence.repository.FoodCartRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class FoodCartAdapter implements FoodCartRepository {
    private final FoodCartJpaRepository foodCartJpaRepository;
    private final FoodCartMapper foodCartMapper;

    @Override
    public FoodCart save(FoodCart foodCart) {
        return foodCartMapper.entityToModel(foodCartJpaRepository.save(foodCartMapper.modelToEntity(foodCart)));
    }
}
