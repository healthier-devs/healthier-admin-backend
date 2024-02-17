package com.healthier.admin.domain.admin.security.jwt;

import com.healthier.admin.domain.admin.security.dto.TokenResponse;
import com.healthier.admin.domain.admin.security.service.AdminUserDetails;
import io.jsonwebtoken.*;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import io.jsonwebtoken.security.SignatureException;
import java.security.Key;
import java.util.Arrays;
import java.util.Collection;
import java.util.Date;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

@Component
public class TokenProvider {

    private static final String AUTHORITIES_KEY = "auth";
    private static final String USERNAME = "username";
    private static final String BLACKLIST_PREFIX = "blacklist:";
    private static final long ACCESS_TOKEN_EXPIRE_TIME = 1000 * 60 * 10;
    private static final long REFRESH_TOKEN_EXPIRE_TIME = 1000 * 60 * 60 * 24 * 7;
    private static final long BLACKLIST_EXPIRE_TIME = 60 * 30;

    //    private final RedisTemplate<String, Object> redisTemplate;
    private final Key key;

    public TokenProvider(@Value("${jwt.secret}") String secretKey) {
        byte[] keyBytes = Decoders.BASE64.decode(secretKey);
        this.key = Keys.hmacShaKeyFor(keyBytes);
    }

    public TokenResponse generateTokenDto(Authentication authentication) {
        // 권한들 가져오기
        String authorities =
                authentication.getAuthorities().stream()
                        .map(GrantedAuthority::getAuthority)
                        .collect(Collectors.joining(","));

        long now = (new Date()).getTime();

        // Access Token 생성
        Date accessTokenExpiresIn = new Date(now + ACCESS_TOKEN_EXPIRE_TIME);

        AdminUserDetails userDetails = (AdminUserDetails) authentication.getPrincipal();

        String accessToken =
                Jwts.builder()
                        .setSubject(authentication.getName()) // payload "sub": "username (email)"
                        .claim(USERNAME, userDetails.getUsername()) // payload "userId" : "user_id"
                        .claim(AUTHORITIES_KEY, authorities) // payload "auth": "ROLE_USER"
                        .setExpiration(accessTokenExpiresIn) // payload "exp": 1516239022
                        .signWith(key, SignatureAlgorithm.HS512) // header "alg": "HS512"
                        .compact();

        // Refresh Token 생성
        String refreshToken =
                Jwts.builder()
                        .setExpiration(new Date(now + REFRESH_TOKEN_EXPIRE_TIME))
                        .signWith(key, SignatureAlgorithm.HS512)
                        .compact();

        return TokenResponse.builder().accessToken(accessToken).refreshToken(refreshToken).build();
    }

    public Authentication getAuthentication(String accessToken) {
        // 토큰 복호화
        Claims claims = parseClaims(accessToken);

        if (claims.get(AUTHORITIES_KEY) == null) {
            throw new BadCredentialsException("Invalid Access Token");
        }

        // 클레임에서 권한 정보 가져오기
        Collection<? extends GrantedAuthority> authorities =
                Arrays.stream(claims.get(AUTHORITIES_KEY).toString().split(","))
                        .map(SimpleGrantedAuthority::new)
                        .collect(Collectors.toList());

        String usernameClaim = claims.get(USERNAME).toString();

        // UserDetails 객체를 만들어서 Authentication 리턴
        UserDetails userDetails =
                User.builder()
                        .username(usernameClaim)
                        .password("")
                        .authorities(authorities)
                        .build();

        return new UsernamePasswordAuthenticationToken(userDetails, "", authorities);
    }

    public boolean validateToken(String token) {
        try {
            Jwts.parserBuilder().setSigningKey(key).build().parseClaimsJws(token);
            //            if (isTokenBlacklisted(token)) {
            //                throw new BadCredentialsException("Invalid Refresh Token: 로그아웃한 JWT
            // 토큰");
            //            }
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

    //    public void blacklistToken(String token) {
    //        String key = BLACKLIST_PREFIX + token;
    //        redisTemplate.opsForValue().set(key, true);
    //        redisTemplate.expire(key, BLACKLIST_EXPIRE_TIME, TimeUnit.SECONDS);
    //    }
    //
    //    private boolean isTokenBlacklisted(String token) {
    //        String key = BLACKLIST_PREFIX + token;
    //        return redisTemplate.hasKey(key);
    //    }

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
