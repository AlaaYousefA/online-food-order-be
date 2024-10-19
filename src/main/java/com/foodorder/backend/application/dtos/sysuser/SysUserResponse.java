package com.foodorder.backend.application.dtos.sysuser;

import com.foodorder.backend.domain.enums.SystemRoleEnum;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SysUserResponse {
    private Long id;

    private Long cartId;

    private SystemRoleEnum role;
}
