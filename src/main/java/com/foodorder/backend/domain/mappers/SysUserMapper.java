package com.foodorder.backend.domain.mappers;

import com.foodorder.backend.domain.model.SysUser;
import com.foodorder.backend.persistence.entity.SysUserEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface SysUserMapper {
    SysUserEntity modelToEntity(SysUser sysUser);
    SysUser entityToModel(SysUserEntity entity);
}
