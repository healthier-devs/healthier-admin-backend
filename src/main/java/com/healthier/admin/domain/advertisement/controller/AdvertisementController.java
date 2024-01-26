package com.healthier.admin.domain.advertisement.controller;

import com.healthier.admin.common.ApiResponse;
import com.healthier.admin.domain.advertisement.dto.AdvertisementDto;
import com.healthier.admin.domain.advertisement.service.AdvertisementService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import java.util.List;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@Tag(name = "광고 관리 API", description = "광고 관리 API 입니다.")
@CrossOrigin
@RequestMapping(value = "/advertisements")
@RequiredArgsConstructor
@RestController
@Slf4j
public class AdvertisementController {
    private final AdvertisementService advertisementService;

    // Create Advertisement
    @Operation(summary = "광고 등록")
    @PostMapping
    public ApiResponse<?> createAdvertisement(@RequestBody AdvertisementDto advertisementDto) {
        advertisementService.createAdvertisement(advertisementDto);
        return ApiResponse.DEFAULT_OK;
    }

    // Get All Advertisements
    @Operation(summary = "광고 전체 조회")
    @GetMapping
    public ApiResponse<List<AdvertisementDto>> getAllAdvertisements() {
        return ApiResponse.createSuccessResponse(advertisementService.getAllAdvertisements());
    }

    // Get Advertisement by ID
    @Operation(summary = "광고 상세 조회")
    @GetMapping("/{id}")
    public ApiResponse<AdvertisementDto> getAdvertisementById(@PathVariable Long id) {
        return ApiResponse.createSuccessResponse(advertisementService.getAdvertisement(id));
    }

    // Update Advertisement
    @Operation(summary = "광고 수정", description = "Every field is required except isPublished")
    @PatchMapping("/{id}")
    public ApiResponse<?> updateAdvertisement(
            @PathVariable Long id, @RequestBody AdvertisementDto advertisementDto) {
        advertisementService.updateAdvertisement(id, advertisementDto);
        return ApiResponse.DEFAULT_OK;
    }

    // Update Advertisement isPublished
    @Operation(summary = "광고 배포 상태 수정", description = "Only Required : isPublished")
    @PatchMapping("/{id}/publish")
    public ApiResponse<?> updateAdvertisementIsPublished(
            @PathVariable Long id, @RequestBody AdvertisementDto advertisementDto) {
        advertisementService.updateAdvertisementIsPublished(id, advertisementDto);
        return ApiResponse.DEFAULT_OK;
    }
}
