package com.foodorder.backend.domain.model;

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
public class Order {
    private Long id;

    private Long totalItems;

    private Double totalPrice;

    // Indicates if items in the order are available
    private Boolean status;

    private LocalDateTime createdAt;

    private Long cartId;
}
