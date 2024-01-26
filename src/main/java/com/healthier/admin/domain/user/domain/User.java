package com.healthier.admin.domain.user.domain;

import com.healthier.admin.common.entity.BaseEntity;
import com.healthier.admin.domain.user.domain.healthInformation.HealthInformation;
import jakarta.persistence.*;
import java.util.List;
import lombok.*;

@Getter
@Entity
@Builder
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class User extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String username;
    private String password;

    @Enumerated(EnumType.STRING)
    private UserStatus status; // 회원 상태

    @Enumerated(EnumType.STRING)
    private RegisterType type; // 회원가입 종류

    @OneToMany(
            mappedBy = "user",
            cascade = CascadeType.ALL,
            orphanRemoval = true,
            fetch = FetchType.LAZY)
    private List<HealthInterest> healthInterests; // 관심 건강 분야

    @OneToOne(mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private HealthInformation healthInformation;

    @OneToOne(mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Profile profile;

    @OneToOne(mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private UserInformation userInformation;
}
