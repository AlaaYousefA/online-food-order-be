package com.foodorder.backend.domain.model;

import com.foodorder.backend.domain.enums.SystemRoleEnum;
import com.foodorder.backend.persistence.entity.CartEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SysUser {
    private Long id;

    private String username;

    private String password;

    private String email;

    private SystemRoleEnum role;

    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;

    private Long cartId;
}
