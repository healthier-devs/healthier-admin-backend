package com.healthier.admin.domain.user.domain.healthInformation;

public enum DrinkingAmount {
    NONE("마시지 않음"),
    LESS_THAN_3_BOTTLES("소주 3병 미만"),
    BETWEEN_3_AND_5_BOTTLES("소주 3-5병"),
    MORE_THAN_5_BOTTLES("소주 5병 이상");

    private String description;

    DrinkingAmount(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return description;
    }
}
