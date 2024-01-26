package com.healthier.admin.domain.advertisement.domain;

import com.healthier.admin.common.entity.BaseEntity;
import com.healthier.admin.domain.advertisement.dto.AdvertisementDto;
import jakarta.persistence.*;
import java.time.LocalDateTime;
import lombok.*;

@Getter
@Entity
@Builder
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

    public static Advertisement fromAdvertisementDto(AdvertisementDto advertisementDto) {
        return Advertisement.builder()
                .startDate(advertisementDto.getStartDate())
                .endDate(advertisementDto.getEndDate())
                .advertiser(advertisementDto.getAdvertiser())
                .title(advertisementDto.getTitle())
                .subtitle(advertisementDto.getSubtitle())
                .image(advertisementDto.getImage())
                .location(AdLocation.valueOf(advertisementDto.getLocation()))
                .url(advertisementDto.getUrl())
                .isPublished(advertisementDto.isPublished())
                .build();
    }

    public void updateAdvertisement(
            LocalDateTime startDate,
            LocalDateTime endDate,
            String advertiser,
            String title,
            String subtitle,
            String image,
            AdLocation location,
            String url) {
        this.startDate = startDate;
        this.endDate = endDate;
        this.advertiser = advertiser;
        this.title = title;
        this.subtitle = subtitle;
        this.image = image;
        this.location = location;
        this.url = url;
    }

    public void updateAdvertisementIsPublished(boolean isPublished) {
        this.isPublished = isPublished;
    }
}
