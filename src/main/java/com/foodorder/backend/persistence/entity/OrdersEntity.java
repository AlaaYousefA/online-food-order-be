package com.foodorder.backend.persistence.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "orders")
public class OrdersEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "quantity")
    private Long quantity;

    @Column(name = "total_price")
    private Double totalPrice;

    @Column(name = "status")// Indicates if items in the order are available
    private Boolean status;

    @Column(name = "created_at")
    private LocalDateTime createdAt;

    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private SysUserEntity userId;

    @ManyToOne
    @JoinColumn(name = "food_item_id", referencedColumnName = "id")
    private FoodItemEntity foodItemId;

    @ManyToOne
    @JoinColumn(name = "cart_id")
    private CartEntity cart;
}
