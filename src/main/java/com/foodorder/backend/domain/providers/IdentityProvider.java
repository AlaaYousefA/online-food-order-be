package com.foodorder.backend.domain.providers;

import com.foodorder.backend.domain.model.SysUser;
import com.foodorder.backend.domain.services.SysUserService;
import com.foodorder.backend.domain.services.security.SysUserDetailsService;
import com.foodorder.backend.persistence.repository.SysUserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class IdentityProvider {
    private final SysUserRepository sysUserRepository;
    private final SysUserDetailsService sysUserDetailsService;

    public SysUser currentIdentity() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if(authentication != null && authentication.isAuthenticated()) {
            if(authentication.getPrincipal() instanceof UserDetails userDetails) {
                return sysUserRepository.findByUsername(userDetails.getUsername());
            }

            if(authentication.getPrincipal() instanceof String username) {
                return sysUserRepository.findByUsername(username);
            }
        }

        return null;
    }

    public UserDetails currentIdentityDetails() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if(authentication != null && authentication.isAuthenticated()) {
            if(authentication.getPrincipal() instanceof UserDetails userDetails) {
                return userDetails;
            }

            if(authentication.getPrincipal() instanceof String username) {
                return sysUserDetailsService.loadUserByUsername(username);
            }
        }

        return null;
    }
}
