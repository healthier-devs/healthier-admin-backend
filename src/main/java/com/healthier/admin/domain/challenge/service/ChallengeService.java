package com.healthier.admin.domain.challenge.service;

import com.healthier.admin.common.dto.ImageUrl;
import com.healthier.admin.common.dto.PageCondition;
import com.healthier.admin.common.dto.PageResponse;
import com.healthier.admin.common.s3.S3UrlGenerator;
import com.healthier.admin.domain.challenge.domain.Challenge;
import com.healthier.admin.domain.challenge.dto.ChallengeRequest;
import com.healthier.admin.domain.challenge.dto.ChallengeResponse;
import com.healthier.admin.domain.challenge.dto.SimpleChallengeResponse;
import com.healthier.admin.domain.challenge.repository.ChallengeRepository;

import java.util.List;
import java.util.UUID;
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
public class ChallengeService {

    private final ChallengeRepository challengeRepository;
    private final S3UrlGenerator s3UrlGenerator;

    // 챌린지 생성
    @Transactional
    public void createChallenge(ChallengeRequest challengeRequest) {
        Challenge challenge = Challenge.from(challengeRequest);
        challengeRepository.save(challenge);
    }

    // 챌린지 상세 페이지 사진
    public ImageUrl createChallengeImageUrl() {
        return s3UrlGenerator.getUrl("challenges", UUID.randomUUID().toString());
    }

    // 챌린지 수정
    @Transactional
    public void updateChallenge(Long id, ChallengeRequest challengeRequest) {
        Challenge challenge = challengeRepository.findById(id).orElseThrow();
        if (challengeRequest.getTitle() != null) challenge.updateTitle(challengeRequest.getTitle());
        if (challengeRequest.getCategory() != null)
            challenge.updateCategory(challengeRequest.getCategory());
        if (challengeRequest.getMidtermGift() != null)
            challenge.updateMidtermGift(challengeRequest.getMidtermGift());
        if (challengeRequest.getFinalGift() != null)
            challenge.updateFinalGift(challengeRequest.getFinalGift());
        if (challengeRequest.getDuration() != null)
            challenge.updateDuration(challengeRequest.getDuration());
        if (challengeRequest.getTimes() != null) challenge.updateTimes(challengeRequest.getTimes());
        if (challengeRequest.getMethod() != null)
            challenge.updateMethod(challengeRequest.getMethod());
        if (challengeRequest.getWhatContent() != null)
            challenge.updateWhatContent(challengeRequest.getWhatContent());
        if (challengeRequest.getWhyContent() != null)
            challenge.updateWhyContent(challengeRequest.getWhyContent());
        if (challengeRequest.getTipSubtitle() != null)
            challenge.updateTipSubtitle(challengeRequest.getTipSubtitle());
        if (challengeRequest.getTipContent() != null)
            challenge.updateTipContent(challengeRequest.getTipContent());
        if (challengeRequest.getGuide() != null) challenge.updateGuide(challengeRequest.getGuide());
        if (challengeRequest.getSuccessImage1() != null)
            challenge.updateSuccessImage1(challenge.getSuccessImage1());
        if (challengeRequest.getSuccessImage2() != null)
            challenge.updateSuccessImage2(challengeRequest.getSuccessImage2());
        if (challengeRequest.getFailImage1() != null)
            challenge.updateFailImage1(challenge.getFailImage1());
        if (challengeRequest.getFailImage2() != null)
            challenge.updateFailImage2(challenge.getFailImage2());
        if (challengeRequest.getIsPublic() != null)
            challenge.updateIsPublic(challengeRequest.getIsPublic());

        challengeRepository.save(challenge);
    }

    @Transactional(readOnly = true)
    public ChallengeResponse getChallenge(Long id) {
        Challenge challenge = challengeRepository.findById(id).orElseThrow();
        return ChallengeResponse.from(challenge);
    }

    @Transactional(readOnly = true)
    public PageResponse<?> getAllChallenges(PageCondition pageCondition) {
        Pageable pageable = PageRequest.of(pageCondition.getPage(), pageCondition.getSize());
        Page<Challenge> challenges = challengeRepository.findAll(pageable);
        List<SimpleChallengeResponse> simpleChallengeResponses = challenges.stream().map(SimpleChallengeResponse::from).toList();
        return new PageResponse<>(simpleChallengeResponses, challenges.getTotalElements());
    }
}
