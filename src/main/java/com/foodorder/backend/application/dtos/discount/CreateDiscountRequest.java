package com.foodorder.backend.application.dtos.discount;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CreateDiscountRequest {
    private String name;

    private Double discountPercentage;
}