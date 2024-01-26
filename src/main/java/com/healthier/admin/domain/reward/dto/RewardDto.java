package com.healthier.admin.domain.reward.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;
import lombok.Getter;

@Getter
public class RewardDto {
    private Long id;

    @Schema(description = "리워드 포인트", example = "3000")
    private Integer point;

    private Integer actualPrice;
    private String imageUrl;

    @Schema(description = "상품권 종류", example = "배달의 민족")
    private String type;

    @Schema(description = "상품권 종류", example = "3000원 상품권")
    private String name;

    @Schema(description = "상품권 유효기간", example = "30")
    private Integer duration;

    @Schema(description = "상품권 이용 유의사항")
    private String productNotice;

    @Schema(description = "리워드 지급 유의사항")
    private String rewardNotice;

    private boolean isPublic;

    @Builder
    private RewardDto(
            Long id,
            Integer point,
            Integer actualPrice,
            String imageUrl,
            String type,
            String name,
            Integer duration,
            String productNotice,
            String rewardNotice,
            boolean isPublic) {
        this.id = id;
        this.point = point;
        this.actualPrice = actualPrice;
        this.imageUrl = imageUrl;
        this.type = type;
        this.name = name;
        this.duration = duration;
        this.productNotice = productNotice;
        this.rewardNotice = rewardNotice;
        this.isPublic = isPublic;
    }

    public static RewardDto fromPreview(com.healthier.admin.domain.reward.domain.Reward reward) {
        return RewardDto.builder()
                .id(reward.getId())
                .point(reward.getPoint())
                .actualPrice(reward.getActualPrice())
                .imageUrl(reward.getImageUrl())
                .type(reward.getType())
                .name(reward.getName())
                .duration(reward.getDuration())
                .productNotice(reward.getProductNotice())
                .rewardNotice(reward.getRewardNotice())
                .isPublic(reward.isPublic())
                .build();
    }

    public static RewardDto fromDetail(com.healthier.admin.domain.reward.domain.Reward reward) {
        String productNoticePreview = getPreview(reward.getProductNotice());
        String rewardNoticePreview = getPreview(reward.getRewardNotice());

        return RewardDto.builder()
                .id(reward.getId())
                .point(reward.getPoint())
                .actualPrice(reward.getActualPrice())
                .type(reward.getType())
                .name(reward.getName())
                .duration(reward.getDuration())
                .productNotice(productNoticePreview)
                .rewardNotice(rewardNoticePreview)
                .isPublic(reward.isPublic())
                .build();
    }

    private static String getPreview(String notice) {
        return (notice != null) ? notice.substring(0, Math.min(15, notice.length())) : null;
    }
}
