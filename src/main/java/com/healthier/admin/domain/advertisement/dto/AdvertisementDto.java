package com.healthier.admin.domain.advertisement.dto;

import com.healthier.admin.domain.advertisement.domain.Advertisement;
import java.time.LocalDateTime;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Builder
public class AdvertisementDto {
    private Long id;
    private String title;
    private LocalDateTime startDate;
    private LocalDateTime endDate;
    private String advertiser;
    private String subtitle;
    private String image;
    private String location;
    private String url;
    private boolean isPublished;

    public static AdvertisementDto fromPreview(Advertisement advertisement) {
        return new AdvertisementDto(
                advertisement.getId(),
                advertisement.getTitle(),
                advertisement.getStartDate(),
                advertisement.getEndDate(),
                advertisement.getAdvertiser(),
                null,
                null,
                advertisement.getLocation().getName(),
                null,
                advertisement.isPublished());
    }

    public static AdvertisementDto fromDetail(Advertisement advertisement) {
        return new AdvertisementDto(
                advertisement.getId(),
                advertisement.getTitle(),
                advertisement.getStartDate(),
                advertisement.getEndDate(),
                advertisement.getAdvertiser(),
                advertisement.getSubtitle(),
                advertisement.getImage(),
                advertisement.getLocation().getName(),
                advertisement.getUrl(),
                advertisement.isPublished());
    }
}
