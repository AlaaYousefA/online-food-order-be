package com.foodorder.backend.application.controllers;

import com.foodorder.backend.application.dtos.sysuser.SysUserRequest;
import com.foodorder.backend.application.dtos.sysuser.SysUserResponse;
import com.foodorder.backend.domain.mappers.SysUserMapper;
import com.foodorder.backend.domain.model.SysUser;
import com.foodorder.backend.domain.services.SysUserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
