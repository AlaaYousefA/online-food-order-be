package com.foodorder.backend.persistence.jpa;

import com.foodorder.backend.domain.model.Discount;
import com.foodorder.backend.persistence.entity.DiscountEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DiscountJpaRepository extends JpaRepository<DiscountEntity, Long> {
}
