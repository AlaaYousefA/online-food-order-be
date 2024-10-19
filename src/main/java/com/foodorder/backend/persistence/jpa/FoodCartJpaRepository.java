package com.foodorder.backend.persistence.jpa;

import com.foodorder.backend.persistence.entity.FoodCartEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FoodCartJpaRepository extends JpaRepository<FoodCartEntity, Long> {
}
