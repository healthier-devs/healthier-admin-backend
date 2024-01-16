package com.healthier.admin.domain.user.domain.healthInformation;

public enum ContinuousMedicineType {
    M_ASPIRIN("아스피린"),
    M_NSAIDS("소염진통제"),
    M_STEROID("스테로이드"),
    M_ANTIBIOTICS("항생제"),
    M_ANTACID_PREPARATION("제산제");

    private String description;

    ContinuousMedicineType(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return description;
    }
}
