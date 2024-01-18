package com.healthier.admin.domain.mongo.dx.domain.dx;

import lombok.Data;

@Data
public class LifestyleHabit {
    private String title; // 생활습관 제목
    private String content; // 생활습관 내용
    private String emoji; // 생활습관 이모지
}
