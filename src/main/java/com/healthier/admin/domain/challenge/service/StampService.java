package com.healthier.admin.domain.challenge.service;

import com.healthier.admin.common.dto.PageCondition;
import com.healthier.admin.common.dto.PageResponse;
import com.healthier.admin.domain.challenge.domain.Stamp;
import com.healthier.admin.domain.challenge.domain.StampStatus;
import com.healthier.admin.domain.challenge.dto.StampResponse;
import com.healthier.admin.domain.challenge.repository.StampRepository;
import java.time.LocalDate;
import java.util.List;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Slf4j
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class StampService {

    private final StampRepository stampRepository;

    // 도장 전체 조회 (페이징)
    // Querydsl 통해 동적 필터링 (status, date)
    public PageResponse<?> getAllStamps(
            PageCondition pageCondition, StampStatus status, LocalDate date) {
        Pageable pageable = PageRequest.of(pageCondition.getPage(), pageCondition.getSize());
        Page<Stamp> stamps = stampRepository.findStampsByFilter(status, date, pageable);
        List<StampResponse> stampListResponse = stamps.stream().map(StampResponse::from).toList();
        return new PageResponse<>(stampListResponse, stamps.getTotalElements());
    }

    // 도장 개별 조회
    public StampResponse getStamp(Long id) {
        return stampRepository
                .findById(id)
                .map(StampResponse::from)
                .orElseThrow(() -> new IllegalArgumentException("해당 인증이 존재하지 않습니다."));
    }

    // 도장 상태 변경
    @Transactional
    public void updateStampStatus(Long id, StampStatus status) {
        Stamp stamp =
                stampRepository
                        .findById(id)
                        .orElseThrow(() -> new IllegalArgumentException("해당 인증이 존재하지 않습니다."));
        stamp.updateStatus(status);
        stampRepository.save(stamp);
    }
}
