package com.healthier.admin.common.controller;

import java.time.LocalDateTime;
import org.springframework.http.CacheControl;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
public class HealthCheckController {

    @GetMapping("/health_check")
    public ResponseEntity<String> healthCheck() {
        return ResponseEntity.ok()
                .cacheControl(CacheControl.noCache())
                .body(LocalDateTime.now().toString());
    }
}
