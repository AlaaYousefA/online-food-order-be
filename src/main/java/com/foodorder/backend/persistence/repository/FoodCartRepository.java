package com.foodorder.backend.persistence.repository;

import com.foodorder.backend.domain.model.FoodCart;
import org.springframework.stereotype.Repository;

@Repository
public interface FoodCartRepository {

    FoodCart save(FoodCart foodCart);
}
