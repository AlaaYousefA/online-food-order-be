package com.foodorder.backend.persistence.adapter;

import com.foodorder.backend.application.exception.ResourceNotFoundException;
import com.foodorder.backend.domain.mappers.DiscountMapper;
import com.foodorder.backend.domain.model.Discount;
import com.foodorder.backend.domain.model.FoodItem;
import com.foodorder.backend.persistence.entity.DiscountEntity;
import com.foodorder.backend.persistence.entity.FoodItemEntity;
import com.foodorder.backend.persistence.jpa.DiscountJpaRepository;
import com.foodorder.backend.persistence.repository.DiscountRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.*;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class DiscountAdapter implements DiscountRepository {
    private final DiscountJpaRepository discountJpaRepository;
    private final DiscountMapper discountMapper;

    @Override
    public Discount save(Discount discount) {
        return discountMapper.entityToModel(discountJpaRepository.save(discountMapper.modelToEntity(discount)));
    }

    @Override
    public void updateDiscountById(Long id, Discount discount) {
        discountJpaRepository.updateDiscount(id, LocalDateTime.now(), discountMapper.modelToEntity(discount));
    }

    @Override
    public Discount getById(Long id) {
        return discountMapper.entityToModel(discountJpaRepository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("Discount with id " + id + " not found")
        ));
    }

    @Override
    public Page<Discount> getAllDiscounts(int page, int size, String sortBy, String sortDirection) {
        Sort.Direction direction = Sort.Direction.fromString(sortDirection);
        Pageable pageable = PageRequest.of(page, size, Sort.by(direction, sortBy));

        Page<DiscountEntity> discountEntities = discountJpaRepository.findAll(pageable);


        List<Discount> discounts = discountEntities
                .stream()
                .map(discountMapper::entityToModel)
                .toList();

        return new PageImpl<>(discounts, pageable, discountEntities.getTotalElements());
    }
}

//