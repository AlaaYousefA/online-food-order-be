package com.foodorder.backend.persistence.jpa;

import com.foodorder.backend.persistence.entity.FoodItemEntity;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;

@Repository
public interface FoodItemJpaRepository extends JpaRepository<FoodItemEntity, Long> {
    @Modifying
    @Transactional
    @Query("UPDATE food_item f SET f.name = :#{#newEntity.name}, " +
            "f.description = :#{#newEntity.description}, " +
            "f.price = :#{#newEntity.price}, " +
            "f.quantity = :#{#newEntity.quantity}, " +
            "f.updatedAt = :updatedAt " +
            "WHERE f.id = :id")
    void updateFoodItem(@Param("id") Long id,
                       @Param("updatedAt") LocalDateTime updatedAt,
                       @Param("newEntity") FoodItemEntity newEntity);
}
