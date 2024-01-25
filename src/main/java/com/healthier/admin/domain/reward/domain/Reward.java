package com.healthier.admin.domain.reward.domain;

import com.healthier.admin.domain.reward.dto.RewardDto;
import jakarta.persistence.*;
import lombok.*;

@Getter
@Entity
@Builder
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Reward {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Integer point;

    private Integer actualPrice;

    private String imageUrl;

    private String type;

    private String name;

    private Integer duration;

    @Column(columnDefinition = "TEXT")
    private String productNotice;

    @Column(columnDefinition = "TEXT")
    private String rewardNotice;

    private boolean isPublic;

    public static Reward from(RewardDto rewardDto) {
        return Reward.builder()
                .point(rewardDto.getPoint())
                .actualPrice(rewardDto.getActualPrice())
                .imageUrl(rewardDto.getImageUrl())
                .type(rewardDto.getType())
                .name(rewardDto.getName())
                .duration(rewardDto.getDuration())
                .productNotice(rewardDto.getProductNotice())
                .rewardNotice(rewardDto.getRewardNotice())
                .isPublic(rewardDto.isPublic())
                .build();
    }

    public void updatePoint(Integer point) {
        this.point = point;
    }

    public void updateActualPrice(Integer actualPrice) {
        this.actualPrice = actualPrice;
    }

    public void updateImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public void updateType(String type) {
        this.type = type;
    }

    public void updateName(String name) {
        this.name = name;
    }

    public void updateDuration(Integer duration) {
        this.duration = duration;
    }

    public void updateProductNotice(String productNotice) {
        this.productNotice = productNotice;
    }

    public void updateRewardNotice(String rewardNotice) {
        this.rewardNotice = rewardNotice;
    }

    public void updateIsPublic(boolean isPublic) {
        this.isPublic = isPublic;
    }
}
