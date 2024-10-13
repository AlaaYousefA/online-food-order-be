package com.foodorder.backend.persistence.repository;

import com.foodorder.backend.domain.model.Discount;
import org.springframework.stereotype.Repository;

@Repository
public interface DiscountRepository {
    Discount save(Discount discount);
}
