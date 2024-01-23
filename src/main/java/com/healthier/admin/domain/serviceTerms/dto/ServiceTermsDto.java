package com.healthier.admin.domain.serviceTerms.dto;

import com.healthier.admin.domain.serviceTerms.domain.ServiceTerms;
import java.time.LocalDateTime;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Builder
public class ServiceTermsDto {
    private Long id;
    private String type;
    private String content;
    private LocalDateTime modifiedAt;

    // Preview
    public static ServiceTermsDto fromPreview(ServiceTerms serviceTerms) {
        return new ServiceTermsDto(
                serviceTerms.getId(),
                serviceTerms.getType().getDescription(),
                null,
                serviceTerms.getModifiedDate());
    }

    // Detail
    public static ServiceTermsDto fromDetail(ServiceTerms serviceTerms) {
        return new ServiceTermsDto(
                serviceTerms.getId(),
                serviceTerms.getType().getDescription(),
                serviceTerms.getContent(),
                serviceTerms.getModifiedDate());
    }
}
