package com.healthier.admin.domain.challenge.domain;

public enum StampStatus {
    NOTHING("미인증"),
    SUCCESS("성공"),
    FAILURE("실패"),
    CHECKING("대기중"),
    REVIVAL("부활티켓적용");

    private final String name;

    StampStatus(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
