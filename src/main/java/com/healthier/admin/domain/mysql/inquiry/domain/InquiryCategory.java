package com.healthier.admin.domain.mysql.inquiry.domain;

public enum InquiryCategory {
    DIAGNOSE("증상감별"),
    HOSPITAL("병원찾기"),
    CHALLENGE("건강챌린지"),
    REWARDS("리워드"),
    USER("로그인/회원정보"),
    OTHERS("기타");

    private String name;

    InquiryCategory(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
