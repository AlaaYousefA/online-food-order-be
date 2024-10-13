package com.foodorder.backend.persistence.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "cart")
public class CartEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "total_price")
    private Double totalPrice;

    @Column(name = "order_confirmed")// is order complete and to the way to the user to deliver (all payment cash only)
    private Boolean orderConfirmed;

    @OneToMany(mappedBy = "cart")
    private List<OrdersEntity> listOfOrders;

    @OneToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private SysUserEntity userId;
}
