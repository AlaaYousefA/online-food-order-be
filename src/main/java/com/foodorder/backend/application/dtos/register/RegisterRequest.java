package com.foodorder.backend.application.dtos.register;

import com.foodorder.backend.domain.enums.SystemRoleEnum;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RegisterRequest {
    private String username;

    private String password;

    private String email;

    private SystemRoleEnum role;
}
