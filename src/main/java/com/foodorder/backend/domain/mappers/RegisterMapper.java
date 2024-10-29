package com.foodorder.backend.domain.mappers;

import com.foodorder.backend.application.dtos.register.RegisterRequest;
import com.foodorder.backend.application.dtos.register.RegisterResponse;
import com.foodorder.backend.domain.model.SysUser;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface RegisterMapper {
    SysUser requestToModel(RegisterRequest registerRequest);

    RegisterResponse modelToResponse(SysUser sysUser);
}
