package com.healthier.admin.domain.inquiry.dto;

import com.healthier.admin.domain.inquiry.domain.InquiryReply;
import lombok.Builder;
import lombok.Getter;

@Getter
public class InquiryReplyDto {
    private String content;

    @Builder
    private InquiryReplyDto(String content) {
        this.content = content;
    }

    public static InquiryReplyDto from(InquiryReply inquiryReply) {
        return InquiryReplyDto.builder().content(inquiryReply.getReplyContent()).build();
    }
}
