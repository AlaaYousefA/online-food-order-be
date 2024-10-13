package com.foodorder.backend.domain.mappers;

import com.foodorder.backend.application.dtos.discount.CreateDiscountRequest;
import com.foodorder.backend.application.dtos.discount.CreateDiscountResponse;
import com.foodorder.backend.domain.model.Discount;
import com.foodorder.backend.persistence.entity.DiscountEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface DiscountMapper {
    Discount CreateDiscountRequestToModel(CreateDiscountRequest request);
    DiscountEntity modelToEntity(Discount discount);
    Discount entityToModel(DiscountEntity discountEntity);
    CreateDiscountResponse modelToCreateDiscountResponse(Discount discount);
}
