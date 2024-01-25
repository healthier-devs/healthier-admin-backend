package com.healthier.admin.domain.reward.dto;

import com.healthier.admin.domain.reward.domain.UserReward;
import java.time.LocalDateTime;
import lombok.Builder;
import lombok.Getter;

@Getter
public class UserRewardResponse {

    private Long id;
    private LocalDateTime challengeClosedAt;
    private String userName;
    private String phoneNumber;
    private String challengeName;
    private String rewardName;
    private boolean isFinal;
    private boolean isSent;

    @Builder
    private UserRewardResponse(
            Long id,
            LocalDateTime challengeClosedAt,
            String userName,
            String phoneNumber,
            String challengeName,
            String rewardName,
            boolean isFinal,
            boolean isSent) {
        this.id = id;
        this.challengeClosedAt = challengeClosedAt;
        this.userName = userName;
        this.phoneNumber = phoneNumber;
        this.challengeName = challengeName;
        this.rewardName = rewardName;
        this.isFinal = isFinal;
        this.isSent = isSent;
    }

    public static UserRewardResponse from(UserReward userReward) {
        return UserRewardResponse.builder()
                .id(userReward.getId())
                .challengeClosedAt(
                        userReward
                                .getUserChallenge()
                                .getEndDate()
                                .atStartOfDay()) // TODO: 챌린지 완료 일시가 어떤 시간 기준인지 확인 필요
                .userName(userReward.getUserChallenge().getUser().getProfile().getName())
                .phoneNumber(userReward.getPhoneNumber())
                .challengeName(userReward.getUserChallenge().getChallenge().getTitle())
                .rewardName(
                        userReward.getReward().getType() + " " + userReward.getReward().getName())
                .isFinal(userReward.isFinal())
                .isSent(userReward.isSent())
                .build();
    }
}
