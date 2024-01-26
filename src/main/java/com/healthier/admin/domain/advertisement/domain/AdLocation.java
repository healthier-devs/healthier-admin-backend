package com.healthier.admin.domain.advertisement.domain;

import java.util.Arrays;
import lombok.Getter;

@Getter
public enum AdLocation {
    MAIN_HOME("메인 홈"),
    CHALLENGE("건강챌린지"),
    SLEEP("수면"),
    NUTRITION("영양제"),
    EATING_HABIT("식습관"),
    EXERCISE("운동");

    private final String name;

    AdLocation(String name) {
        this.name = name;
    }

    public static AdLocation fromString(String name) {
        return Arrays.stream(AdLocation.values())
                .filter(location -> location.getName().equals(name))
                .findFirst()
                .orElseThrow(
                        () -> new IllegalArgumentException("No enum constant found for " + name));
    }
}
