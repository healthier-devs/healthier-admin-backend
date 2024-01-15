package com.healthier.admin.domain.user.domain.healthInformation;

import jakarta.persistence.Embeddable;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Embeddable
public class SmokingAmount {
    private boolean isSmoking; // 흡연 유무
    private int years; // Y 년 동안
    private int timesPerDay; // 하루 N 번 피웠어요

    // Default
    public static SmokingAmount createDefaultSmoking() {
        SmokingAmount smokingAmount = new SmokingAmount();
        smokingAmount.setSmoking(false);
        smokingAmount.setYears(0);
        smokingAmount.setTimesPerDay(0);
        return smokingAmount;
    }
}
