package com.foodorder.backend.application.dtos.food;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CreateFoodItemRequest {
    private String name;

    private String description;

    private Double price;

    private Long quantity;
}
