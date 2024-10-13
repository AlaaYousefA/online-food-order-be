package com.foodorder.backend.domain.services;

import com.foodorder.backend.domain.model.Discount;
import com.foodorder.backend.persistence.repository.DiscountRepository;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class DiscountService {
    private final DiscountRepository discountRepository;

    public Discount createDiscount(Discount discount) {
        discount.setCreatedAt(LocalDateTime.now());
        discount.setUpdatedAt(LocalDateTime.now());

        return discountRepository.save(discount);
    }
}
