package com.foodorder.backend.domain.mappers;

import com.foodorder.backend.domain.model.FoodCart;
import com.foodorder.backend.domain.model.Order;
import com.foodorder.backend.persistence.entity.FoodCartEntity;
import com.foodorder.backend.persistence.entity.OrdersEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface OrderMapper {
    @Mapping(source = "cartId", target = "cart.id")
    OrdersEntity modelToEntity(Order order);

    @Mapping(source = "cart.id", target = "cartId")
    Order entityToModel(OrdersEntity entity);
}
