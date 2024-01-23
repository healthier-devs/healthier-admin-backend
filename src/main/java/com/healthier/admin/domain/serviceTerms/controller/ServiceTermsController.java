package com.healthier.admin.domain.serviceTerms.controller;

import com.healthier.admin.common.ApiResponse;
import com.healthier.admin.domain.serviceTerms.dto.ServiceTermsDto;
import com.healthier.admin.domain.serviceTerms.service.ServiceTermsService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import java.util.List;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@Tag(name = "약관 API", description = "약관 API 입니다.")
@CrossOrigin
@RequestMapping(value = "/serviceTerms")
@RequiredArgsConstructor
@RestController
@Slf4j
public class ServiceTermsController {
    private final ServiceTermsService serviceTermsService;

    // Get All Service Terms
    @Operation(summary = "서비스 약관 전체 조회")
    @GetMapping("/")
    public ApiResponse<List<ServiceTermsDto>> getAllServiceTerms() {
        return ApiResponse.createSuccessResponse(serviceTermsService.getAllServiceTerms());
    }

    // Get Service Term by ID
    @Operation(summary = "서비스 약관 개별 조회")
    @GetMapping("/{id}")
    public ApiResponse<ServiceTermsDto> getServiceTerms(@PathVariable Long id) {
        return ApiResponse.createSuccessResponse(serviceTermsService.getServiceTerms(id));
    }

    // Update Service Term
    @Operation(summary = "서비스 약관 수정")
    @PatchMapping("/{id}")
    public ApiResponse<?> updateServiceTerms(
            @PathVariable Long id, @RequestBody ServiceTermsDto serviceTermsDto) {
        serviceTermsService.updateServiceTerms(id, serviceTermsDto);
        return ApiResponse.DEFAULT_OK;
    }
}
