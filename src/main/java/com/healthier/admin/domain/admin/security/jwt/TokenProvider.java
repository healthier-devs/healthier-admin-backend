package com.healthier.admin.domain.admin.security.jwt;

import com.healthier.admin.domain.admin.security.dto.TokenResponse;
import com.healthier.admin.domain.admin.security.service.AdminUserDetails;
import io.jsonwebtoken.*;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import io.jsonwebtoken.security.SignatureException;
import java.security.Key;
import java.util.Date;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

@Component
public class TokenProvider {
    private static final String USERNAME = "username";

    @Value("${jwt.access-expiration-time}")
    private int accessExpirationTime;

    private final Key key;

    public TokenProvider(@Value("${jwt.secret}") String secretKey) {
        byte[] keyBytes = Decoders.BASE64.decode(secretKey);
        this.key = Keys.hmacShaKeyFor(keyBytes);
    }

    public TokenResponse generateTokenDto(Authentication authentication) {
        long now = (new Date()).getTime();

        // Access Token 생성
        Date accessTokenExpiresIn = new Date(now + accessExpirationTime);

        AdminUserDetails userDetails = (AdminUserDetails) authentication.getPrincipal();

        String accessToken =
                Jwts.builder()
                        .setSubject(authentication.getName())
                        .claim(USERNAME, userDetails.getUsername())
                        .setExpiration(accessTokenExpiresIn)
                        .signWith(key, SignatureAlgorithm.HS512)
                        .compact();

        return TokenResponse.builder().accessToken(accessToken).build();
    }

    public Authentication getAuthentication(String accessToken) {
        // 토큰 복호화
        Claims claims = parseClaims(accessToken);

        String usernameClaim = claims.get(USERNAME).toString();

        // UserDetails 객체를 만들어서 Authentication 리턴
        UserDetails userDetails = User.builder().username(usernameClaim).password("").build();

        return new UsernamePasswordAuthenticationToken(
                userDetails, "", userDetails.getAuthorities());
    }

    public boolean validateToken(String token) {
        try {
            Jwts.parserBuilder().setSigningKey(key).build().parseClaimsJws(token);
        } catch (SecurityException | MalformedJwtException e) {
            throw new BadCredentialsException("Invalid Access Token: 잘못된 JWT 서명");
        } catch (ExpiredJwtException e) {
            throw new BadCredentialsException("Expired Access Token: 만료된 JWT 토큰");
        } catch (UnsupportedJwtException e) {
            throw new BadCredentialsException("Invalid Access Token: 지원되지 않는 JWT 토큰");
        } catch (IllegalArgumentException | SignatureException e) {
            throw new BadCredentialsException("Invalid Access Token: 잘못된 JWT 토큰");
        }

        return true;
    }

    private Claims parseClaims(String accessToken) {
        try {
            return Jwts.parserBuilder()
                    .setSigningKey(key)
                    .build()
                    .parseClaimsJws(accessToken)
                    .getBody();
        } catch (ExpiredJwtException e) {
            return e.getClaims();
        }
    }
}
