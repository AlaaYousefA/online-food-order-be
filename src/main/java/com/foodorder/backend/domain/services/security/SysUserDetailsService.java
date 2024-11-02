package com.foodorder.backend.domain.services.security;

import com.foodorder.backend.domain.enums.SystemRoleEnum;
import com.foodorder.backend.domain.model.SysUser;
import com.foodorder.backend.persistence.repository.SysUserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SysUserDetailsService implements UserDetailsService {
    private final SysUserRepository sysUserRepository; // mapper between sys-user and user

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        SysUser sysUser = sysUserRepository.findByUsername(username);
        return User.builder()
                .username(sysUser.getUsername())
                .password(sysUser.getPassword())
                .roles(getRoles(sysUser))
                .build();
    }

    private String getRoles(SysUser sysUser) {
        if(sysUser.getRole().toString().isBlank()) {
            return SystemRoleEnum.USER.name();
        }
        return sysUser.getRole().toString();
    }
}
