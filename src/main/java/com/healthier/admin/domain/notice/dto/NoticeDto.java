package com.healthier.admin.domain.notice.dto;

import com.healthier.admin.domain.notice.domain.Notice;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Builder
public class NoticeDto {
    private Long id;
    private String title;
    private String category;
    private String content;
    private LocalDateTime createdAt;
    private LocalDateTime modifiedAt;

    public static NoticeDto fromPreview(Notice notice) {
        return new NoticeDto(
                notice.getId(),
                notice.getTitle(),
                notice.getCategory().getDescription(),
                null,
                notice.getCreatedDate(),
                notice.getModifiedDate());
    }

    public static NoticeDto fromDetail(Notice notice) {
        return new NoticeDto(
                notice.getId(),
                notice.getTitle(),
                notice.getCategory().getDescription(),
                notice.getContent(),
                notice.getCreatedDate(),
                notice.getModifiedDate());
    }
}
