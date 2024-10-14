package com.foodorder.backend.application.dtos.cart;

import com.foodorder.backend.persistence.entity.OrdersEntity;
import com.foodorder.backend.persistence.entity.SysUserEntity;
import jakarta.persistence.Column;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CartRequest {
    private List<OrdersEntity> listOfOrders;

    private Long userId;
}
