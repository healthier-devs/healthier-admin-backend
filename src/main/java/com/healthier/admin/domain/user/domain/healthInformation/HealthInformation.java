package com.healthier.admin.domain.user.domain.healthInformation;

import com.healthier.admin.domain.user.domain.User;
import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.List;
import lombok.*;

@Getter
@Entity
@Builder
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class HealthInformation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    // 주량
    @Enumerated(EnumType.STRING)
    private DrinkingAmount drinkingAmount;

    // 흡연량
    @Embedded private SmokingAmount smokingAmount;

    // 기저질환 1:N
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "health_information_id")
    private List<UnderlyingDisease> underlyingDiseases = new ArrayList<>();

    // 복용약  1:N
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "health_information_id")
    private List<Medicine> medicines = new ArrayList<>();

    // 지속적으로 먹는 약  1:N
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "health_information_id")
    private List<ContinuousMedicine> continuousMedicines = new ArrayList<>();

    // 이전 수술 1:N
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "health_information_id")
    private List<PrevSurgery> prevSurgery = new ArrayList<>();
}
