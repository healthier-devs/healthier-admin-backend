package com.healthier.admin.domain.challenge.dto;

import com.healthier.admin.domain.challenge.domain.Challenge;
import lombok.Builder;
import lombok.Getter;

@Getter
public class SimpleChallengeResponse {
    private Long id;
    private String title;
    private String category;
    private boolean isPublic;

    @Builder
    private SimpleChallengeResponse(Long id, String title, String category, boolean isPublic) {
        this.id = id;
        this.title = title;
        this.category = category;
        this.isPublic = isPublic;
    }

    public static SimpleChallengeResponse from(Challenge challenge){
        return SimpleChallengeResponse.builder()
                .id(challenge.getId())
                .title(challenge.getTitle())
                .category(challenge.getCategory().getName())
                .isPublic(challenge.isPublic())
                .build();
    }
}
