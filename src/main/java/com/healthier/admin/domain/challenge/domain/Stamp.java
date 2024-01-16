package com.healthier.admin.domain.challenge.domain;

import com.healthier.admin.common.entity.BaseEntity;
import jakarta.persistence.*;
import java.time.LocalDateTime;
import lombok.*;

@Getter
@Entity
@Builder
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Stamp extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_challenge_id")
    private UserChallenge userChallenge;

    @Enumerated(EnumType.STRING)
    private StampStatus status;

    private Integer currentDays;
    private LocalDateTime submitTime;
    private String image;
}
