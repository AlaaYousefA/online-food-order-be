package com.foodorder.backend.domain.providers;

import com.foodorder.backend.domain.model.SysUser;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class IdentityProvider {
    public SysUser currentIdentity() {
        return null;
    }
}
