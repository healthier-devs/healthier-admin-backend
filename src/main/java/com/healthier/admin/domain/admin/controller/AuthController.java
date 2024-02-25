package com.healthier.admin.domain.admin.controller;

import com.healthier.admin.common.ApiResponse;
import com.healthier.admin.domain.admin.security.dto.LoginRequest;
import com.healthier.admin.domain.admin.security.dto.TokenResponse;
import com.healthier.admin.domain.admin.service.AuthService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@Tag(name = "Auth API", description = "Auth API 입니다.")
@CrossOrigin
@RequestMapping(value = "/auth")
@RequiredArgsConstructor
@RestController
@Slf4j
public class AuthController {
    private final AuthService authService;

    // 관리자 로그인
    @PostMapping("/signin")
    @Operation(summary = "관리자 로그인")
    public ApiResponse<TokenResponse> login(@RequestBody LoginRequest loginRequest) {
        return ApiResponse.createSuccessResponse(authService.login(loginRequest));
    }
}
