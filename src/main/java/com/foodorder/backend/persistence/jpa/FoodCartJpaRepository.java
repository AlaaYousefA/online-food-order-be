package com.foodorder.backend.persistence.jpa;

import com.foodorder.backend.persistence.entity.FoodCartEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FoodCartJpaRepository extends JpaRepository<FoodCartEntity, Long> {
    @Query("SELECT COUNT(fc) FROM food_cart fc WHERE fc.cart.id = :cartId")
    Long countFoodCartItems(@Param("cartId") Long cartId);

    @Query("SELECT f FROM food_cart f WHERE f.cart.id = :cartId")
    List<FoodCartEntity> findByCartId(@Param("cartId") Long cartId);

}
