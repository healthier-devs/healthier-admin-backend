package com.healthier.admin.domain.notice.domain;

import lombok.Getter;

@Getter
public enum NoticeCategory {
    NOTICE("공지"),
    EVENT("이벤트"),
    CHALLENGE("건강챌린지"),
    REWARD("리워드"),
    MEMBER_LOGIN("회원/로그인"),
    ETC("기타");

    private String description;

    NoticeCategory(String description) {
        this.description = description;
    }
}
