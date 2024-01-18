package com.healthier.admin.domain.mysql.challenge.domain;

public enum StampStatus {
    NOTHING("미인증"),
    SUCCESS("인증성공"),
    FAILURE("인증실패"),
    CHECKING("확인중"),
    REVIVAL("부활티켓적용");

    private final String status;

    StampStatus(String status) {
        this.status = status;
    }

    public String getStatus() {
        return status;
    }
}
