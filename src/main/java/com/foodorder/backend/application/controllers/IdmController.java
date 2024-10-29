package com.foodorder.backend.application.controllers;

import com.foodorder.backend.application.dtos.authentication.UserAuthenticationRequest;
import com.foodorder.backend.application.dtos.authentication.UserAuthenticationResponse;
import com.foodorder.backend.application.dtos.register.RegisterRequest;
import com.foodorder.backend.application.dtos.register.RegisterResponse;
import com.foodorder.backend.domain.mappers.RegisterMapper;
import com.foodorder.backend.domain.mappers.UserAuthenticationMapper;
import com.foodorder.backend.domain.services.IdmService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/idm")
@RequiredArgsConstructor
public class IdmController {
    private final IdmService idmService;
    private final RegisterMapper registerMapper;
    private final UserAuthenticationMapper userAuthenticationMapper;

    @PostMapping("/register")
    public ResponseEntity<RegisterResponse> register(@RequestBody RegisterRequest request){
        return ResponseEntity.ok(registerMapper.modelToResponse(idmService.register(registerMapper.requestToModel(request))));
    }

    @PostMapping("/login")
    public ResponseEntity<UserAuthenticationResponse> login(@RequestBody UserAuthenticationRequest request){
        return ResponseEntity.ok(userAuthenticationMapper.modelToResponse(idmService.login(userAuthenticationMapper.requestToModel(request))));
    }
}
