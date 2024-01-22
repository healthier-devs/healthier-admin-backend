package com.healthier.admin.common.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class PageResponse<T> {

    private T data;
    private Long total;

    public PageResponse(T data, Long total) {
        this.data = data;
        this.total = total;
    }
}
