package com.healthier.admin.domain.mysql.serviceTerms.domain;

import com.healthier.admin.common.entity.BaseEntity;
import jakarta.persistence.*;
import lombok.*;

@Getter
@Entity
@Builder
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class ServiceTerms extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private TermsType type;

    @Column(columnDefinition = "TEXT")
    private String content;
}
