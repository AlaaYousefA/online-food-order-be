package com.foodorder.backend.domain.mappers;

import com.foodorder.backend.application.dtos.sysuser.SysUserRequest;
import com.foodorder.backend.application.dtos.sysuser.SysUserResponse;
import com.foodorder.backend.domain.model.SysUser;
import com.foodorder.backend.persistence.entity.SysUserEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface SysUserMapper {
    @Mapping(source = "cartId", target = "cart.id")
    SysUserEntity modelToEntity(SysUser sysUser);

    @Mapping(source = "cart.id", target = "cartId")
    SysUser entityToModel(SysUserEntity entity);

    SysUser requestToModel(SysUserRequest request);
    SysUserResponse modelToResponse(SysUser sysUser);
}
