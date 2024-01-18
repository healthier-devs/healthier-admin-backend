package com.healthier.admin.domain.mysql.user.domain;

import jakarta.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import lombok.*;

@Getter
@Entity
@Builder
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class UserInformation {

    @Id
    @Column(name = "user_id", nullable = false)
    private Long id;

    @MapsId
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    private LocalDate registrationDate; // 가입 날짜

    private String withdrawalReason; // 탈퇴 이유
    private LocalDate withdrawalDate; // 탈퇴 날짜

    private String fcmToken;
    private LocalDateTime fcmTokenTimestamp;

    private boolean marketingOptIn; // 마케팅 수신 동의 여부
    private LocalDate marketingOptInDate; // 마케팅 수신 동의 날짜

    private boolean pushOptIn; // 푸시 알림 수신 동의 여부

    private String invitationCode;
}
