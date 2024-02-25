package com.healthier.admin.domain.admin.security.service;

import com.healthier.admin.domain.admin.domain.Admin;
import com.healthier.admin.domain.admin.repository.AdminRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AdminUserDetailsService implements UserDetailsService {

    private final AdminRepository adminRepository;

    @Override
    public AdminUserDetails loadUserByUsername(String username) {
        Admin admin =
                adminRepository
                        .findByUsername(username)
                        .orElseThrow(() -> new UsernameNotFoundException("사용자를 찾을 수 없습니다."));
        return new AdminUserDetails(admin);
    }
}
