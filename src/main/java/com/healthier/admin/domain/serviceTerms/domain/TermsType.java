package com.healthier.admin.domain.serviceTerms.domain;

import lombok.Getter;

@Getter
public enum TermsType {
    TERMS_OF_USE("서비스 이용약관"),
    PRIVACY_POLICY("개인정보 처리방침");

    private String description;

    TermsType(String description) {
        this.description = description;
    }
}
