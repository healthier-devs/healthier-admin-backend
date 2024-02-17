package com.healthier.admin.domain.admin.service;

import com.healthier.admin.domain.admin.security.dto.LoginRequest;
import com.healthier.admin.domain.admin.security.dto.TokenResponse;
import com.healthier.admin.domain.admin.security.jwt.TokenProvider;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class AuthService {

    private final AuthenticationManagerBuilder authenticationManagerBuilder;
    private final TokenProvider tokenProvider;

    @Transactional
    public TokenResponse login(LoginRequest loginRequest) {
        // AuthenticationToken 생성
        UsernamePasswordAuthenticationToken authenticationToken = loginRequest.toAuthentication();

        // 검증
        Authentication authentication =
                authenticationManagerBuilder.getObject().authenticate(authenticationToken);

        // JWT 토큰 생성
        return tokenProvider.generateTokenDto(authentication);
    }
}
