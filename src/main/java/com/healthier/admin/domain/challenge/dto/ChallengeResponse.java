package com.healthier.admin.domain.challenge.dto;

import com.healthier.admin.domain.challenge.domain.Challenge;
import lombok.Builder;
import lombok.Getter;

@Getter
public class ChallengeResponse {
    private Long id;
    private String title;
    private String category;
    private Integer participationCount; // 참여 인원
    private Integer midtermGift;
    private Integer finalGift;
    private String duration;
    private String times;
    private String method;
    private String basicImage;
    private String whatContent;
    private String whyContent;
    private String tipSubtitle;
    private String tipContent;
    private String guide;
    private String successImage1;
    private String successImage2;
    private String failImage1;
    private String failImage2;
    private boolean isPublic;

    @Builder
    private ChallengeResponse(
            Long id,
            String title,
            String category,
            Integer participationCount,
            Integer midtermGift,
            Integer finalGift,
            String duration,
            String times,
            String method,
            String basicImage,
            String whatContent,
            String whyContent,
            String tipSubtitle,
            String tipContent,
            String guide,
            String successImage1,
            String successImage2,
            String failImage1,
            String failImage2,
            boolean isPublic) {
        this.id = id;
        this.title = title;
        this.category = category;
        this.participationCount = participationCount;
        this.midtermGift = midtermGift;
        this.finalGift = finalGift;
        this.duration = duration;
        this.times = times;
        this.method = method;
        this.basicImage = basicImage;
        this.whatContent = whatContent;
        this.whyContent = whyContent;
        this.tipSubtitle = tipSubtitle;
        this.tipContent = tipContent;
        this.guide = guide;
        this.successImage1 = successImage1;
        this.successImage2 = successImage2;
        this.failImage1 = failImage1;
        this.failImage2 = failImage2;
        this.isPublic = isPublic;
    }

    public static ChallengeResponse from(Challenge challenge) {
        return ChallengeResponse.builder()
                .id(challenge.getId())
                .title(challenge.getTitle())
                .category(challenge.getCategory().getName())
                .participationCount(challenge.getCount())
                .midtermGift(challenge.getMidtermGift())
                .finalGift(challenge.getFinalGift())
                .duration(String.format("%d일 동안", challenge.getDuration()))
                .times(challenge.getTimes())
                .method(challenge.getMethod())
                .basicImage(challenge.getBasicImage())
                .whatContent(challenge.getWhatContent())
                .whyContent(challenge.getWhyContent())
                .tipSubtitle(challenge.getTipSubtitle())
                .tipContent(challenge.getTipContent())
                .guide(challenge.getGuide())
                .successImage1(challenge.getSuccessImage1())
                .successImage2(challenge.getSuccessImage2())
                .failImage1(challenge.getFailImage1())
                .failImage2(challenge.getFailImage2())
                .isPublic(challenge.isPublic())
                .build();
    }
}
