package com.foodorder.backend.persistence.jpa;

import com.foodorder.backend.persistence.entity.OrdersEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderJpaRepository extends JpaRepository<OrdersEntity, Long> {
}
