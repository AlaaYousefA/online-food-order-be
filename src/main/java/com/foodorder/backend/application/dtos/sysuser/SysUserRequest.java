package com.foodorder.backend.application.dtos.sysuser;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SysUserRequest {
    private String username;

    private String password;

    private String email;
}
