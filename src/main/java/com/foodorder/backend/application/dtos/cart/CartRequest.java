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

    @Column(name = "order_confirmed")// is order complete and to the way to the user to deliver (all payment cash only)
    private Boolean orderConfirmed;

    @OneToMany(mappedBy = "cart")
    private List<OrdersEntity> listOfOrders;

    @OneToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private SysUserEntity userId;
}
