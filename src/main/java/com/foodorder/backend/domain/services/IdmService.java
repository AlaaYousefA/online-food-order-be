package com.foodorder.backend.domain.services;

import com.foodorder.backend.application.exception.DuplicateResourceException;
import com.foodorder.backend.application.exception.InvalidCredentialsException;
import com.foodorder.backend.domain.model.Cart;
import com.foodorder.backend.domain.model.SysUser;
import com.foodorder.backend.domain.model.UserAuthentication;
import com.foodorder.backend.domain.services.security.JwtService;
import com.foodorder.backend.domain.services.security.SysUserDetailsService;
import com.foodorder.backend.persistence.repository.CartRepository;
import com.foodorder.backend.persistence.repository.SysUserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class IdmService {
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;
    private final SysUserDetailsService sysUserDetailsService;
    private final SysUserRepository sysUserRepository;
    private final PasswordEncoder passwordEncoder;
    private final CartRepository cartRepository;

    public SysUser register(SysUser user) {
        validateUserInfo(user);
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        fillUpMissingInfo(user);
        return sysUserRepository.save(user);
    }

    public UserAuthentication login(UserAuthentication userAuthentication) {
        Authentication authentication = getAuthenticationStatus(userAuthentication);
        if(authentication.isAuthenticated()) {
            updateSecurityContextHolder(authentication);
            return buildUserAuthentication(userAuthentication);
        }

        throw new InvalidCredentialsException("Bad credentials, username or password are incorrect");
    }

    private static void updateSecurityContextHolder(Authentication authentication) {
        SecurityContextHolder.getContext().setAuthentication(authentication);
    }

    private void validateUserInfo(SysUser user) {

        if(sysUserRepository.isUsernameAlreadyExists(user.getUsername())) {
            throw new DuplicateResourceException("Username already exists");
        }
    }

    private void fillUpMissingInfo(SysUser user) {
        user.setCreatedAt(LocalDateTime.now());
        user.setUpdatedAt(LocalDateTime.now());

        Cart cart = Cart.builder()
                .createdAt(LocalDateTime.now())
                .updatedAt(LocalDateTime.now())
                .build();
        Cart savedCart = cartRepository.save(cart);

        user.setCartId(savedCart.getId());
    }

    private UserAuthentication buildUserAuthentication(UserAuthentication userAuthentication) {
        UserDetails user = sysUserDetailsService.loadUserByUsername(userAuthentication.getUsername());
        String token = jwtService.generateToken(user);
        userAuthentication.setToken(token);
        return userAuthentication;
    }

    private Authentication getAuthenticationStatus(UserAuthentication endUserAuthentication) {
        return authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        endUserAuthentication.getUsername(),
                        endUserAuthentication.getPassword()
                )
        );
    }
}
