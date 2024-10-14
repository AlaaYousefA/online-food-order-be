package com.foodorder.backend.domain.model;

import com.foodorder.backend.persistence.entity.OrdersEntity;
import com.foodorder.backend.persistence.entity.SysUserEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Cart {
    private Long id;

    private BigDecimal totalPrice;

    private Boolean orderConfirmed;
}
