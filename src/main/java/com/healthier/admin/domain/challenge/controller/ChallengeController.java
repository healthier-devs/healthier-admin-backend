package com.healthier.admin.domain.challenge.controller;

import com.healthier.admin.common.dto.ImageUrl;
import com.healthier.admin.common.dto.PageCondition;
import com.healthier.admin.common.dto.PageResponse;
import com.healthier.admin.domain.challenge.dto.ChallengeRequest;
import com.healthier.admin.domain.challenge.dto.ChallengeResponse;
import com.healthier.admin.domain.challenge.service.ChallengeService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springdoc.core.annotations.ParameterObject;
import org.springframework.web.bind.annotation.*;

@Tag(name = "챌린지 API", description = "건강챌린지 admin API입니다.")
@CrossOrigin
@RequestMapping(value = "/challenges")
@RequiredArgsConstructor
@RestController
@Slf4j
public class ChallengeController {

    private final ChallengeService challengeService;

    @Operation(summary = "챌린지 생성")
    @PostMapping
    public void createChallenge(@RequestBody ChallengeRequest challengeRequest) {
        challengeService.createChallenge(challengeRequest);
    }

    @Operation(summary = "챌린지 상세 이미지 url 생성하기")
    @GetMapping("/image")
    public ImageUrl getChallengeImageUrl() {
        return challengeService.createChallengeImageUrl();
    }

    @Operation(summary = "챌린지 수정")
    @PatchMapping("/{id}")
    public void updateChallenge(
            @PathVariable Long id, @RequestBody ChallengeRequest challengeRequest) {
        challengeService.updateChallenge(id, challengeRequest);
    }

    @Operation(summary = "챌린지 개별 조회")
    @GetMapping("/{id}")
    public ChallengeResponse getChallenge(@PathVariable Long id) {
        return challengeService.getChallenge(id);
    }

    @Operation(summary = "챌린지 전체 조회")
    @GetMapping
    public PageResponse<?> getAllChallenges(@ParameterObject PageCondition pageCondition) {
        return challengeService.getAllChallenges(pageCondition);
    }
}
