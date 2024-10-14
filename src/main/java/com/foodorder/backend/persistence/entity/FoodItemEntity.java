package com.foodorder.backend.persistence.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Data
@Entity(name = "food_item")
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "food_item")
public class FoodItemEntity { // 6
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "description")
    private String description;

    @Column(name = "price")
    private Double price;

    @Column(name = "quantity")
    private Long quantity;

    @ManyToOne
    @JoinColumn(name = "discount_id", referencedColumnName = "id", nullable = true)
    private DiscountEntity discount;

    @Column(name = "created_at")
    private LocalDateTime createdAt;

    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

    @OneToMany(mappedBy = "foodItem")
    private List<FoodCartEntity> foodCartEntries; // Represents all the carts that contain this food item (one-to-many)
}
