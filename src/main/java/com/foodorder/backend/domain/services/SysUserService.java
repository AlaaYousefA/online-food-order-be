package com.foodorder.backend.domain.services;

import com.foodorder.backend.domain.model.Cart;
import com.foodorder.backend.domain.model.SysUser;
import com.foodorder.backend.persistence.repository.CartRepository;
import com.foodorder.backend.persistence.repository.SysUserRepository;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class SysUserService {
    private final SysUserRepository sysUserRepository;
    private final CartRepository cartRepository;

    public SysUser getUserById(Long id) {
        return sysUserRepository.getUserById(id);
    }

    public SysUser createUser(SysUser sysUser) {
        Cart cart = Cart.builder()
                .createdAt(LocalDateTime.now())
                .updatedAt(LocalDateTime.now())
                .build();
        Cart savedCart = cartRepository.save(cart);

        sysUser.setCreatedAt(LocalDateTime.now());
        sysUser.setUpdatedAt(LocalDateTime.now());
        sysUser.setCartId(savedCart.getId());

        return sysUserRepository.save(sysUser);
    }
}
