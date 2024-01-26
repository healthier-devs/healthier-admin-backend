package com.healthier.admin.domain.reward.controller;

import com.healthier.admin.common.ApiResponse;
import com.healthier.admin.common.dto.PageCondition;
import com.healthier.admin.common.dto.PageResponse;
import com.healthier.admin.domain.reward.dto.RewardDto;
import com.healthier.admin.domain.reward.dto.UserRewardResponse;
import com.healthier.admin.domain.reward.service.RewardService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springdoc.core.annotations.ParameterObject;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "리워드 API", description = "리워드 API 입니다.")
@CrossOrigin
@RequestMapping(value = "/rewards")
@RequiredArgsConstructor
@RestController
@Slf4j
public class RewardController {
    private final RewardService rewardService;

    // 리워드 목록 조회
    @Operation(summary = "리워드 목록 조회")
    @GetMapping
    public ApiResponse<PageResponse<List<RewardDto>>> getAllRewards(@ParameterObject PageCondition pageCondition) {
        return ApiResponse.createSuccessResponse(rewardService.getAllRewards(pageCondition));
    }

    // 리워드 개별 조회
    @Operation(summary = "리워드 개별 조회")
    @GetMapping("/{id}")
    public ApiResponse<RewardDto> getReward(@PathVariable Long id) {
        return ApiResponse.createSuccessResponse(rewardService.getReward(id));
    }

    // 리워드 생성
    @Operation(summary = "리워드 생성")
    @PostMapping
    public ApiResponse<?> createReward(@RequestBody RewardDto rewardDto) {
        rewardService.createReward(rewardDto);
        return ApiResponse.DEFAULT_OK;
    }

    // 리워드 수정
    @Operation(summary = "리워드 수정")
    @PatchMapping("/{id}")
    public ApiResponse<?> updateReward(@PathVariable Long id, @RequestBody RewardDto rewardDto) {
        rewardService.updateReward(id, rewardDto);
        return ApiResponse.DEFAULT_OK;
    }

    // 리워드 지급 전체 조회
    @Operation(summary = "리워드 지급 전체 조회")
    @GetMapping("/user")
    public ApiResponse<PageResponse<List<UserRewardResponse>>> getAllUserRewards(@ParameterObject PageCondition pageCondition) {
        return ApiResponse.createSuccessResponse(rewardService.getAllUserRewards(pageCondition));
    }

    // 리워드 지급 상태 변경
    @Operation(summary = "리워드 지급 상태 변경")
    @PatchMapping("/user/{id}")
    public ApiResponse<?> updateSendStatus(@PathVariable Long id) {
        rewardService.updateSendStatus(id);
        return ApiResponse.DEFAULT_OK;
    }
}
