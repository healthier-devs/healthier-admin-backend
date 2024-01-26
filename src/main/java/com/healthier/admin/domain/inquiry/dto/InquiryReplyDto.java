package com.healthier.admin.domain.inquiry.dto;

import lombok.Builder;
import lombok.Getter;

@Getter
public class InquiryReplyDto {
    private String content;

    @Builder
    private InquiryReplyDto(String content) {
        this.content = content;
    }

    public static InquiryReplyDto from(String content) {
        return InquiryReplyDto.builder().content(content).build();
    }
}
