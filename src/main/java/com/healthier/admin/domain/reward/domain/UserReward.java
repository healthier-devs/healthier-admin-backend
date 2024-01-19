package com.healthier.admin.domain.reward.domain;

import com.healthier.admin.common.entity.BaseEntity;
import com.healthier.admin.domain.challenge.domain.Challenge;
import com.healthier.admin.domain.user.domain.User;
import jakarta.persistence.*;
import lombok.*;

@Getter
@Entity
@Builder
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class UserReward extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    private String phoneNumber;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "challenge_id")
    private Challenge challenge;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "reward_id")
    private Reward reward;

    private Integer point;

    private boolean isSelected;

    private boolean isSent;

    private boolean isFinal;
}
