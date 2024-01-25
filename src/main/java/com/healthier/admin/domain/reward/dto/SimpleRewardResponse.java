package com.healthier.admin.domain.reward.dto;

import com.healthier.admin.domain.reward.domain.Reward;
import lombok.Builder;
import lombok.Getter;

@Getter
public class SimpleRewardResponse {

    private Long id;
    private Integer point;
    private Integer actualPrice;
    private String type;
    private String name;
    private Integer duration;
    private String productNotice;
    private String rewardNotice;
    private boolean isPublic;

    @Builder
    private SimpleRewardResponse(
            Long id,
            Integer point,
            Integer actualPrice,
            String type,
            String name,
            Integer duration,
            String productNotice,
            String rewardNotice,
            boolean isPublic) {
        this.id = id;
        this.point = point;
        this.actualPrice = actualPrice;
        this.type = type;
        this.name = name;
        this.duration = duration;
        this.productNotice = productNotice;
        this.rewardNotice = rewardNotice;
        this.isPublic = isPublic;
    }

    public static SimpleRewardResponse from(Reward reward) {
        return SimpleRewardResponse.builder()
                .id(reward.getId())
                .point(reward.getPoint())
                .actualPrice(reward.getActualPrice())
                .type(reward.getType())
                .name(reward.getName())
                .duration(reward.getDuration())
                .productNotice(reward.getProductNotice().substring(0, 15))
                .rewardNotice(reward.getRewardNotice().substring(0, 15))
                .isPublic(reward.isPublic())
                .build();
    }
}
