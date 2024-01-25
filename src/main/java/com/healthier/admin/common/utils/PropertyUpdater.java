package com.healthier.admin.common.utils;

import java.util.Optional;
import java.util.function.Consumer;

public class PropertyUpdater {

    public static <T> void updateProperty(T value, Consumer<T> updateMethod) {
        Optional.ofNullable(value).ifPresent(updateMethod);
    }
}
