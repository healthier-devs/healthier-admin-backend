package com.healthier.admin.domain.challenge.domain;

import com.healthier.admin.common.entity.BaseEntity;
import jakarta.persistence.*;
import lombok.*;

@Getter
@Entity
@Builder
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Challenge extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    private String category;
    private Integer count; // 참여 인원
    private Integer midtermGift;
    private Integer finalGift;
    private Integer duration;
    private String times;
    private String method;
    private String notice;
    private String basicImage;

    @Column(columnDefinition = "TEXT")
    private String whatContent;

    @Column(columnDefinition = "TEXT")
    private String whyContent;

    private String tipSubtitle;

    @Column(columnDefinition = "TEXT")
    private String tipContent;

    private String guide;
    private String successImage1;
    private String successImage2;
    private String failImage1;
    private String failImage2;

    @Enumerated(EnumType.STRING)
    private ChallengeStatus status;
}
