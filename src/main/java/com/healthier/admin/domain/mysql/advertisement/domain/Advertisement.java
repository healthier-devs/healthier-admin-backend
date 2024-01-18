package com.healthier.admin.domain.mysql.advertisement.domain;

import com.healthier.admin.common.entity.BaseEntity;
import jakarta.persistence.*;
import java.time.LocalDateTime;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Entity
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Advertisement extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDateTime startDate;

    private LocalDateTime endDate;

    private String advertiser;

    private String title; // 광고 제품 메인 타이틀

    private String subtitle; // 광고 제품 서브 타이틀

    private String image; // 광고 이미지

    @Enumerated(EnumType.STRING)
    private AdLocation location; // 배너 위치

    private String url; // 광고 링크

    private boolean isPublished; // 배포상태 (공개/비공개)
}
