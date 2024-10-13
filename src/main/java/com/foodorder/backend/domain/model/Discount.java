package com.foodorder.backend.domain.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Discount {
    private Long id;

    private String name;

    private Double discountPercentage;

    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;
}
