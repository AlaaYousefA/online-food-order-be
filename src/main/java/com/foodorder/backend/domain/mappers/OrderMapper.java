package com.foodorder.backend.domain.mappers;

import com.foodorder.backend.domain.model.Order;
import com.foodorder.backend.persistence.entity.OrdersEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface OrderMapper {
    OrdersEntity modelToEntity(Order order);
    Order entityToModel(OrdersEntity entity);
}
