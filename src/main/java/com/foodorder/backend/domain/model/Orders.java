package com.foodorder.backend.domain.model;

import com.foodorder.backend.persistence.entity.CartEntity;
import com.foodorder.backend.persistence.entity.FoodItemEntity;
import com.foodorder.backend.persistence.entity.SysUserEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Orders {
    private Long id;

    private Long quantity;

    private Double totalPrice;
    // Indicates if items in the order are available
    private Boolean status;

    private LocalDateTime createdAt;

    private SysUserEntity userId;

    private FoodItemEntity foodItemId;

    private CartEntity chart;
}
