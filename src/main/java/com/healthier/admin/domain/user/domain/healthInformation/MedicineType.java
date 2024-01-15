package com.healthier.admin.domain.user.domain.healthInformation;

public enum MedicineType {
    M_HIGH_BLOOD_PRESSURE("고혈압약"),
    M_HEPATITIS("간염약"),
    M_DIABETES("당뇨약"),
    M_TUBERCULOSIS("결핵약"),
    M_HYPERLIPIDEMIA("고지혈증약"),
    M_ALLERGY("알러지약"),
    M_HEART_DISEASE("심장질환약"),
    M_GALLSTONE("담석약");

    private String description;

    MedicineType(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return description;
    }
}
