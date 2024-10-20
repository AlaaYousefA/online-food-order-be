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

    @Column(name = "total_items")
    private Long totalItems;

    @Column(name = "total_price")
    private Double totalPrice;

    @Column(name = "status")// Indicates if the order confirmed or not
    private Boolean status;

    @Column(name = "created_at")
    private LocalDateTime createdAt;

    @OneToOne
    @JoinColumn(name = "cart_id", referencedColumnName = "id")
    private CartEntity cart;
}
