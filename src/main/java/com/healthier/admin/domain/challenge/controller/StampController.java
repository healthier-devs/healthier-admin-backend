package com.healthier.admin.domain.challenge.controller;

import com.healthier.admin.common.dto.PageCondition;
import com.healthier.admin.common.dto.PageResponse;
import com.healthier.admin.domain.challenge.domain.StampStatus;
import com.healthier.admin.domain.challenge.dto.StampResponse;
import com.healthier.admin.domain.challenge.service.StampService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import java.time.LocalDate;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springdoc.core.annotations.ParameterObject;
import org.springframework.web.bind.annotation.*;

@Tag(name = "도장판 API", description = "건강챌린지 인증(도장) 관리 API입니다.")
@CrossOrigin
@RequestMapping(value = "/stamps")
@RequiredArgsConstructor
@RestController
@Slf4j
public class StampController {

    private final StampService stampService;

    // 도장 전체 조회하기
    @Operation(summary = "인증 전체 조회")
    @GetMapping
    public PageResponse<?> getAllStamps(
            @ParameterObject PageCondition pageCondition,
            @RequestParam(required = false) StampStatus status,
            @RequestParam(required = false) LocalDate date) {
        return stampService.getAllStamps(pageCondition, status, date);
    }

    // 도장 개별 조회하기
    @Operation(summary = "인증 개별 조회")
    @GetMapping("/{id}")
    public StampResponse getStamp(@PathVariable Long id) {
        return stampService.getStamp(id);
    }

    // 도장 상태 변경하기
    @Operation(summary = "인증 상태 변경")
    @PatchMapping("/{id}")
    public void updateStampStatus(@PathVariable Long id, @RequestParam StampStatus status) {
        stampService.updateStampStatus(id, status);
    }
}
