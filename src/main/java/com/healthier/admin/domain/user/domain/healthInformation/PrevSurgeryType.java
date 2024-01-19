package com.healthier.admin.domain.user.domain.healthInformation;

public enum PrevSurgeryType {
    S_CANCER("암 수술"),
    S_OB_GYN("산부인과 시술 혹은 수술"),
    S_BRAIN("뇌 수술"),
    S_ABDOMINAL("복부 수술"),
    S_APPENDICITIS("맹장염(충수돌기염) 수술");

    private String description;

    PrevSurgeryType(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return description;
    }
}
