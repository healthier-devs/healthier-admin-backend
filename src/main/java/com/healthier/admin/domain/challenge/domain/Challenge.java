package com.healthier.admin.domain.challenge.domain;

import com.healthier.admin.common.entity.BaseEntity;
import com.healthier.admin.domain.challenge.dto.ChallengeRequest;
import jakarta.persistence.*;
import lombok.*;

@Getter
@Entity
@Builder
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Challenge extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    private ChallengeCategory category;
    private Integer count; // 참여 인원
    private Integer midtermGift;
    private Integer finalGift;
    private Integer duration;
    private String times;
    private String method;
    private String basicImage;

    @Column(columnDefinition = "TEXT")
    private String whatContent;

    @Column(columnDefinition = "TEXT")
    private String whyContent;

    private String tipSubtitle;

    @Column(columnDefinition = "TEXT")
    private String tipContent;

    private String guide;
    private String successImage1;
    private String successImage2;
    private String failImage1;
    private String failImage2;

    private boolean isPublic;

    public static Challenge from(ChallengeRequest challengeRequest) {
        return Challenge.builder()
                .category(challengeRequest.getCategory())
                .title(challengeRequest.getTitle())
                .count(0)
                .midtermGift(challengeRequest.getMidtermGift())
                .finalGift(challengeRequest.getFinalGift())
                .duration(challengeRequest.getDuration())
                .basicImage(challengeRequest.getImage())
                .method(challengeRequest.getMethod())
                .times(challengeRequest.getTimes())
                .tipContent(challengeRequest.getTipContent())
                .tipSubtitle(challengeRequest.getTipSubtitle())
                .guide(challengeRequest.getGuide())
                .successImage1(challengeRequest.getSuccessImage1())
                .successImage2(challengeRequest.getSuccessImage2())
                .failImage1(challengeRequest.getFailImage1())
                .failImage2(challengeRequest.getFailImage2())
                .whatContent(challengeRequest.getWhatContent())
                .whyContent(challengeRequest.getWhyContent())
                .isPublic(challengeRequest.getIsPublic())
                .build();
    }

    public void updateTitle(String title) {
        this.title = title;
    }

    public void updateCategory(ChallengeCategory category) {
        this.category = category;
    }

    public void updateMidtermGift(Integer midtermGift) {
        this.midtermGift = midtermGift;
    }

    public void updateFinalGift(Integer finalGift) {
        this.finalGift = finalGift;
    }

    public void updateDuration(Integer duration) {
        this.duration = duration;
    }

    public void updateTimes(String times) {
        this.times = times;
    }

    public void updateMethod(String method) {
        this.method = method;
    }

    public void updateBasicImage(String basicImage) {
        this.basicImage = basicImage;
    }

    public void updateWhatContent(String whatContent) {
        this.whatContent = whatContent;
    }

    public void updateWhyContent(String whyContent) {
        this.whyContent = whyContent;
    }

    public void updateTipSubtitle(String tipSubtitle) {
        this.tipSubtitle = tipSubtitle;
    }

    public void updateTipContent(String tipContent) {
        this.tipContent = tipContent;
    }

    public void updateGuide(String guide) {
        this.guide = guide;
    }

    public void updateSuccessImage1(String successImage1) {
        this.successImage1 = successImage1;
    }

    public void updateSuccessImage2(String successImage2) {
        this.successImage2 = successImage2;
    }

    public void updateFailImage1(String failImage1) {
        this.failImage1 = failImage1;
    }

    public void updateFailImage2(String failImage2) {
        this.failImage2 = failImage2;
    }

    public void updateIsPublic(Boolean isPublic) {
        this.isPublic = isPublic;
    }
}
