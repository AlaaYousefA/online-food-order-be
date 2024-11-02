package com.foodorder.backend.domain.mappers;

import com.foodorder.backend.application.dtos.authentication.UserAuthenticationRequest;
import com.foodorder.backend.application.dtos.authentication.UserAuthenticationResponse;
import com.foodorder.backend.application.dtos.sysuser.SysUserRequest;
import com.foodorder.backend.application.dtos.sysuser.SysUserResponse;
import com.foodorder.backend.domain.model.SysUser;
import com.foodorder.backend.domain.model.UserAuthentication;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserAuthenticationMapper {
    UserAuthentication requestToModel(UserAuthenticationRequest userAuthenticationRequest);
    UserAuthenticationResponse modelToResponse(UserAuthentication userAuthentication);
}
