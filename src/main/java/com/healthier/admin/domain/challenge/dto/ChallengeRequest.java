package com.healthier.admin.domain.challenge.dto;

import com.healthier.admin.domain.challenge.domain.ChallengeCategory;
import lombok.Getter;

@Getter
public class ChallengeRequest {
    private String title;
    private ChallengeCategory category;
    private Integer midtermGift;
    private Integer finalGift;
    private Integer duration;
    private String times;
    private String method;
    private String whatContent;
    private String whyContent;
    private String tipSubtitle;
    private String tipContent;
    private String guide;
    private String successImage1;
    private String successImage2;
    private String failImage1;
    private String failImage2;
    private Boolean isPublic;
    private String image;
}
