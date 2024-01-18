package com.healthier.admin.domain.mysql.challenge.domain;

public enum UserChallengeStatus {
    PROGRESS("진행중"),
    GIVEUP("포기"),
    CLOSED("종료");

    private final String status;

    UserChallengeStatus(String status) {
        this.status = status;
    }

    public String getStatus() {
        return status;
    }
}
