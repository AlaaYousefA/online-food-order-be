package com.foodorder.backend.domain.model;

import com.foodorder.backend.persistence.entity.CartEntity;
import com.foodorder.backend.persistence.entity.FoodItemEntity;
import jakarta.persistence.Column;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class FoodCart {
    private Long id;

    private Long quantity;

    private LocalDateTime createdAt;

    private Long cartId;

    private Long foodItemId;
}
