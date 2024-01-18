package com.healthier.admin.domain.mongo.dx.domain.dx;

import java.util.List;
import lombok.Data;

@Data
public class Medicine {
    private String name; // 이름
    private String img; // 이미지
    private String efficacyEffectiveness; // 효능/효과
    private List<String> ingredient; // 종류
    private List<String> types; // 종류
    private List<String> dosageUsage; // 용량 및 용법
    private String caution; // 복용 시 주의
    private List<String> sideEffects; // 부작용
}
