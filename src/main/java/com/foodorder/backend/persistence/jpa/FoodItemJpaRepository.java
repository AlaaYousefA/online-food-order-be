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
    @Query(value = """
        UPDATE food_item f
        SET f.name = CASE WHEN :#{#newEntity.name} IS NOT NULL THEN :#{#newEntity.name} ELSE f.name END,
            f.description = CASE WHEN :#{#newEntity.description} IS NOT NULL THEN :#{#newEntity.description} ELSE f.description END,
            f.price = CASE WHEN :#{#newEntity.price} IS NOT NULL THEN :#{#newEntity.price} ELSE f.price END,
            f.quantity = CASE WHEN :#{#newEntity.quantity} IS NOT NULL THEN :#{#newEntity.quantity} ELSE f.quantity END,
            f.discount.id = CASE WHEN :#{#newEntity.discount.id} IS NOT NULL THEN :#{#newEntity.discount.id} ELSE f.discount.id END,
            f.updatedAt = :updatedAt
        WHERE f.id = :id
    """)
    void updateFoodItem(@Param("id") Long id,
                       @Param("updatedAt") LocalDateTime updatedAt,
                       @Param("newEntity") FoodItemEntity newEntity);
}
