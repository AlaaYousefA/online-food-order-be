package com.foodorder.backend.persistence.jpa;

import com.foodorder.backend.domain.model.Discount;
import com.foodorder.backend.persistence.entity.DiscountEntity;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;

@Repository
public interface DiscountJpaRepository extends JpaRepository<DiscountEntity, Long> {
    @Modifying
    @Transactional
    @Query("""
        UPDATE discount f
        SET f.name = CASE WHEN :#{#newEntity.name} IS NOT NULL THEN :#{#newEntity.name} ELSE f.name END,
            f.discountPercentage = CASE WHEN :#{#newEntity.discountPercentage} IS NOT NULL THEN :#{#newEntity.discountPercentage} ELSE f.discountPercentage END,
            f.updatedAt = :updatedAt
        WHERE f.id = :id
    """)
    void updateDiscount(Long id, LocalDateTime updatedAt, DiscountEntity newEntity);
}
