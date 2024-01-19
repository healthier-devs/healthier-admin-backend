package com.healthier.admin.domain.challenge.domain;

public enum ChallengeStatus {
    READY("준비중"),
    PROGRESS("진행중"),
    CLOSED("종료");

    private final String status;

    ChallengeStatus(String status) {
        this.status = status;
    }

    public String getStatus() {
        return status;
    }
}
