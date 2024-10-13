package com.foodorder.backend.persistence.adapter;

import com.foodorder.backend.domain.mappers.DiscountMapper;
import com.foodorder.backend.domain.model.Discount;
import com.foodorder.backend.persistence.entity.DiscountEntity;
import com.foodorder.backend.persistence.jpa.DiscountJpaRepository;
import com.foodorder.backend.persistence.repository.DiscountRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class DiscountAdapter implements DiscountRepository {
    private final DiscountJpaRepository discountJpaRepository;
    private final DiscountMapper discountMapper;

    @Override
    public Discount save(Discount discount) {
        return discountMapper.entityToModel(discountJpaRepository.save(discountMapper.modelToEntity(discount)));
    }
}

//