package com.foodorder.backend.persistence.repository;

import com.foodorder.backend.domain.model.Discount;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Repository;

@Repository
public interface DiscountRepository {
    Discount save(Discount discount);

    void updateDiscountById(Long id, Discount discount);

    Discount getById(Long id);

    Page<Discount> getAllDiscounts(int page, int size, String sortBy, String sortDirection);
}
