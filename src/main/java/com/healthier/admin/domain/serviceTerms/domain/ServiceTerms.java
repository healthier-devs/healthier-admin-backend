package com.healthier.admin.domain.serviceTerms.domain;

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

    @Enumerated(EnumType.STRING)
    private TermsType type;

    @Column(columnDefinition = "TEXT")
    private String content;

    public void updateServiceTerms(TermsType type, String content) {
        this.type = type;
        this.content = content;
    }
}
