package com.healthier.admin.domain.serviceTerms.service;

import com.healthier.admin.domain.serviceTerms.domain.ServiceTerms;
import com.healthier.admin.domain.serviceTerms.domain.TermsType;
import com.healthier.admin.domain.serviceTerms.dto.ServiceTermsDto;
import com.healthier.admin.domain.serviceTerms.repository.ServiceTermsRepository;
import java.util.List;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class ServiceTermsService {
    private final ServiceTermsRepository serviceTermsRepository;

    // 서비스 약관 전체 조회 GET
    public List<ServiceTermsDto> getAllServiceTerms() {
        return serviceTermsRepository.findAll().stream()
                .map(ServiceTermsDto::fromPreview)
                .collect(Collectors.toList());
    }

    // 서비스 약관 개별 조회 GET
    public ServiceTermsDto getServiceTerms(Long id) {
        return serviceTermsRepository
                .findById(id)
                .map(ServiceTermsDto::fromDetail)
                .orElseThrow(() -> new IllegalArgumentException("해당 약관이 존재하지 않습니다."));
    }

    // 서비스 약관 수정 PATCH
    @Transactional
    public void updateServiceTerms(Long id, ServiceTermsDto serviceTermsDto) {
        ServiceTerms updatedServiceTerms =
                serviceTermsRepository
                        .findById(id)
                        .map(
                                serviceTerms -> {
                                    serviceTerms.updateServiceTerms(
                                            TermsType.valueOf(serviceTermsDto.getType()),
                                            serviceTermsDto.getContent());
                                    return serviceTerms;
                                })
                        .orElseThrow(() -> new IllegalArgumentException("해당 약관이 존재하지 않습니다."));

        serviceTermsRepository.save(updatedServiceTerms);
    }
}
