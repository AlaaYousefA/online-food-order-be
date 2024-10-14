package com.foodorder.backend.persistence.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;
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
    private BigDecimal totalPrice;

    @Column(name = "order_confirmed")// is order complete and to the way to the user to deliver (all payment cash only)
    private Boolean orderConfirmed;

    @Column(name = "created_at")
    private LocalDateTime createdAt;

    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

    @OneToOne(mappedBy = "cart") // 'cart' is the field in OrdersEntity that maps this relationship
    private OrdersEntity order;

    @OneToMany(mappedBy = "cart")
    private List<FoodCartEntity> foodCartEntries; // Represents all the food items in the cart (one-to-many)
}
