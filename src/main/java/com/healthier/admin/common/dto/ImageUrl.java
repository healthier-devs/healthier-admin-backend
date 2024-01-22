package com.healthier.admin.common.dto;

import lombok.Builder;
import lombok.Getter;

@Getter
public class ImageUrl {
    private String url;

    @Builder
    private ImageUrl(String url) {
        this.url = url;
    }

    public static ImageUrl to(String url) {
        return ImageUrl.builder().url(url).build();
    }
}
