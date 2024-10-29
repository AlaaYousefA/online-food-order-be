package com.foodorder.backend.domain.providers;

import com.foodorder.backend.domain.model.SysUser;
import com.foodorder.backend.persistence.repository.SysUserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class IdentityProvider {
    private final SysUserRepository sysUserRepository;
    public SysUser currentIdentity() {
        return sysUserRepository.getUserById(1L);
    }
}
