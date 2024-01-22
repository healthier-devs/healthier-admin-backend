package com.healthier.admin.domain.challenge.domain;

public enum ChallengeCategory {
    SLEEP("수면"),
    DIET("식습관"),
    SUPPLEMENT("영양제"),
    EXERCISE("운동");

    private final String name;

    public String getName() {
        return name;
    }

    ChallengeCategory(String name) {
        this.name = name;
    }
}
