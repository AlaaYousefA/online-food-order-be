package com.foodorder.backend.persistence.jpa;

import com.foodorder.backend.persistence.entity.OrdersEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderJpaRepository extends JpaRepository<OrdersEntity, Long> {
    @Query("SELECT SUM(fc.quantity * " +
            "CASE " +
            "  WHEN fi.discount IS NOT NULL THEN fi.price * (1 - fi.discount.discountPercentage / 100) " +
            "  ELSE fi.price " +
            "END) " +
            "FROM food_cart fc " +
            "JOIN fc.foodItem fi " +
            "WHERE fc.cart.id = :cartId")
    Double calculateTotalPrice(@Param("cartId") Long cartId);



    @Query("SELECT COUNT(fc) = 0 " +
            "FROM food_cart fc " +
            "JOIN fc.foodItem fi " +
            "WHERE fc.cart.id = :cartId " +
            "AND fc.quantity > fi.quantity")
    Boolean isItemsInCartAvailable(@Param("cartId") Long cartId);


    @Modifying
    @Query(value = "UPDATE food_item fi " +
            "JOIN food_cart fc ON fi.id = fc.food_item_id " +
            "SET fi.quantity = fi.quantity - fc.quantity " +
            "WHERE fc.cart_id = :cartId",
            nativeQuery = true)
    void updateFoodItemsQuantityByOrder(@Param("cartId") Long cartId);



}
