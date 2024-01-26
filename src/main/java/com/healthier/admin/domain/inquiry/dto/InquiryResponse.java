package com.healthier.admin.domain.inquiry.dto;

import com.healthier.admin.domain.inquiry.domain.Inquiry;
import com.healthier.admin.domain.inquiry.domain.InquiryImage;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import lombok.Builder;
import lombok.Getter;

@Getter
public class InquiryResponse {
    private Long id;
    private LocalDateTime createdAt;
    private String title;
    private String content;
    private String category;
    private String isAnswered;
    private List<String> images;
    private InquiryReplyDto reply;

    @Builder
    private InquiryResponse(
            Long id,
            LocalDateTime createdAt,
            String title,
            String content,
            String category,
            String isAnswered,
            List<String> images,
            InquiryReplyDto reply) {
        this.id = id;
        this.createdAt = createdAt;
        this.title = title;
        this.content = content;
        this.category = category;
        this.isAnswered = isAnswered;
        this.images = images;
        this.reply = reply;
    }

    public static InquiryResponse fromPreview(Inquiry inquiry) {
        return InquiryResponse.builder()
                .id(inquiry.getId())
                .createdAt(inquiry.getCreatedDate())
                .title(inquiry.getTitle())
                .category(inquiry.getCategory().getName())
                .isAnswered(inquiry.isAnswered() ? "답변완료" : "대기중")
                .build();
    }

    public static InquiryResponse fromDetail(Inquiry inquiry) {
        return InquiryResponse.builder()
                .id(inquiry.getId())
                .title(inquiry.getTitle())
                .content(inquiry.getContent())
                .category(inquiry.getCategory().getName())
                .images(
                        Optional.ofNullable(inquiry.getImages())
                                .map(images -> images.stream().map(InquiryImage::getUrl).toList())
                                .orElse(null))
                .reply(
                        InquiryReplyDto.from(
                                inquiry.getReply() != null
                                        ? inquiry.getReply().getReplyContent()
                                        : null))
                .build();
    }
}
