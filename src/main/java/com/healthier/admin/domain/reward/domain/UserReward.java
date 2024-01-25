package com.healthier.admin.domain.reward.domain;

import com.healthier.admin.common.entity.BaseEntity;
import com.healthier.admin.domain.challenge.domain.UserChallenge;
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
    @JoinColumn(name = "userchallenge_id")
    private UserChallenge userChallenge;

    private String phoneNumber;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "reward_id")
    private Reward reward;

    private Integer point;

    private boolean isSelected;

    private boolean isSent;

    private boolean isFinal;

    public void updateIsSent() {
        this.isSent = true;
    }
}
