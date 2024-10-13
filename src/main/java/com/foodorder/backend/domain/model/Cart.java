package com.foodorder.backend.domain.model;

import com.foodorder.backend.persistence.entity.OrdersEntity;
import com.foodorder.backend.persistence.entity.SysUserEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Cart {
    private Long id;

    private Double totalPrice;
    // is order complete and to the way to the user to deliver (all payment cash only)
    private Boolean orderConfirmed;

    private Long userId;
}
