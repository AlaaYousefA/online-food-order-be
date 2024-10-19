package com.foodorder.backend.domain.mappers;


import com.foodorder.backend.domain.model.Cart;
import com.foodorder.backend.persistence.entity.CartEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CartMapper {
    CartEntity modelToEntity(Cart cart);
    Cart entityToModel(CartEntity cartEntity);
}
