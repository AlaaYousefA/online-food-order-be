package com.foodorder.backend.domain.model;

import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class FoodItem {
    private Long id;

    private String name;

    private String description;

    private Double price;

    private Long quantity;

    private Long discountId;

    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;
}
