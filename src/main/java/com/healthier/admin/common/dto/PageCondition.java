package com.healthier.admin.common.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.NoArgsConstructor;

@NoArgsConstructor
public class PageCondition {
    @Schema(title = "페이지", defaultValue = "0")
    private Integer page;

    @Schema(title = "페이지 사이즈", defaultValue = "10")
    private Integer size;

    public Integer getPage() {
        if (page == null) {
            return 0;
        }
        return page;
    }

    public Integer getSize() {
        if (size == null) {
            return 10;
        }
        return size;
    }
}
