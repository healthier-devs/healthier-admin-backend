package com.healthier.admin.domain.mysql.user.domain;

import jakarta.persistence.*;
import java.time.LocalDate;
import lombok.*;

@Getter
@Entity
@Builder
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Profile {

    @Id
    @Column(name = "user_id", nullable = false)
    private Long id;

    @MapsId
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    private String name; // 실명
    private String nickname;
    private LocalDate birthDate;
    private String gender;
    private String phoneNumber; // 전화번호

    private Integer tickets;
}
