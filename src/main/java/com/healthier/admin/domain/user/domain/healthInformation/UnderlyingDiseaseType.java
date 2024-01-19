package com.healthier.admin.domain.user.domain.healthInformation;

public enum UnderlyingDiseaseType {
    HIGH_BLOOD_PRESSURE("고혈압"),
    HEPATITIS("간염"),
    DIABETES("당뇨"),
    TUBERCULOSIS("결핵"),
    HYPERLIPIDEMIA("고지혈증"),
    ALLERGY("알러지"),
    HEART_DISEASE("심장질환"),
    GALLSTONE("담석");

    private String description;

    UnderlyingDiseaseType(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return description;
    }
}
