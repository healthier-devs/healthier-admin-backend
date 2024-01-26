package com.healthier.admin.domain.challenge.domain;

import com.healthier.admin.common.entity.BaseEntity;
import com.healthier.admin.domain.reward.domain.UserReward;
import com.healthier.admin.domain.user.domain.User;
import jakarta.persistence.*;
import java.time.LocalDate;
import java.util.List;
import lombok.*;

@Getter
@Builder
@Entity
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class UserChallenge extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "challenge_id")
    private Challenge challenge;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    @OneToMany(mappedBy = "userChallenge", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Stamp> stamps;

    private LocalDate joinDate;

    private LocalDate endDate;

    private LocalDate giveUpDate;

    private Float successPercentage;

    @Enumerated(value = EnumType.STRING)
    private UserChallengeStatus userChallengeStatus;

    @OneToMany(
            mappedBy = "userChallenge",
            cascade = CascadeType.ALL,
            orphanRemoval = true,
            fetch = FetchType.LAZY)
    private List<UserReward> rewards;
}
