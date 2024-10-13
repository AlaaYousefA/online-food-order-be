package com.foodorder.backend.application.controllers;

import com.foodorder.backend.domain.model.SysUser;
import com.foodorder.backend.domain.services.SysUserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/users")
@RequiredArgsConstructor
public class SysUserController {
    private final SysUserService sysUserService;

    @GetMapping("/{id}")
    public ResponseEntity<SysUser> getUserById(@PathVariable Long id) {
        return ResponseEntity.ok(sysUserService.getUserById(id));
    }
}
