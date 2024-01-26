package com.healthier.admin.domain.challenge.service;

import static com.healthier.admin.common.utils.PropertyUpdater.updateProperty;

import com.healthier.admin.common.dto.ImageUrl;
import com.healthier.admin.common.dto.PageCondition;
import com.healthier.admin.common.dto.PageResponse;
import com.healthier.admin.common.s3.S3UrlGenerator;
import com.healthier.admin.domain.challenge.domain.Challenge;
import com.healthier.admin.domain.challenge.dto.ChallengeRequest;
import com.healthier.admin.domain.challenge.dto.ChallengeResponse;
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
@Transactional(readOnly = true)
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
        Challenge challenge =
                challengeRepository
                        .findById(id)
                        .orElseThrow(() -> new IllegalArgumentException("해당 챌린지가 존재하지 않습니다."));

        updateProperty(challengeRequest.getTitle(), challenge::updateTitle);
        updateProperty(challengeRequest.getCategory(), challenge::updateCategory);
        updateProperty(challengeRequest.getMidtermGift(), challenge::updateMidtermGift);
        updateProperty(challengeRequest.getFinalGift(), challenge::updateFinalGift);
        updateProperty(challengeRequest.getDuration(), challenge::updateDuration);
        updateProperty(challengeRequest.getTimes(), challenge::updateTimes);
        updateProperty(challengeRequest.getMethod(), challenge::updateMethod);
        updateProperty(challengeRequest.getWhatContent(), challenge::updateWhatContent);
        updateProperty(challengeRequest.getWhyContent(), challenge::updateWhyContent);
        updateProperty(challengeRequest.getTipSubtitle(), challenge::updateTipSubtitle);
        updateProperty(challengeRequest.getTipContent(), challenge::updateTipContent);
        updateProperty(challengeRequest.getGuide(), challenge::updateGuide);
        updateProperty(challengeRequest.getSuccessImage1(), challenge::updateSuccessImage1);
        updateProperty(challengeRequest.getSuccessImage2(), challenge::updateSuccessImage2);
        updateProperty(challengeRequest.getFailImage1(), challenge::updateFailImage1);
        updateProperty(challengeRequest.getFailImage2(), challenge::updateFailImage2);
        updateProperty(challengeRequest.getIsPublic(), challenge::updateIsPublic);
        updateProperty(challengeRequest.getImage(), challenge::updateBasicImage);

        challengeRepository.save(challenge);
    }

    // 챌린지 개별조회
    public ChallengeResponse getChallenge(Long id) {
        Challenge challenge =
                challengeRepository
                        .findById(id)
                        .orElseThrow(() -> new IllegalArgumentException("해당 챌린지가 존재하지 않습니다."));
        return ChallengeResponse.fromDetail(challenge);
    }

    // 챌린지 전체 조회
    public PageResponse<List<ChallengeResponse>> getAllChallenges(PageCondition pageCondition) {
        Pageable pageable = PageRequest.of(pageCondition.getPage(), pageCondition.getSize());
        Page<Challenge> challenges = challengeRepository.findAll(pageable);
        List<ChallengeResponse> challengeResponses =
                challenges.map(ChallengeResponse::fromPreview).toList();
        return new PageResponse<>(challengeResponses, challenges.getTotalElements());
    }
}
