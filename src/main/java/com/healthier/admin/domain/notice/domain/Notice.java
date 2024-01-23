package com.healthier.admin.domain.notice.domain;

import com.healthier.admin.common.entity.BaseEntity;
import com.healthier.admin.domain.notice.dto.NoticeDto;
import jakarta.persistence.*;
import lombok.*;

@Getter
@Entity
@Builder
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Notice extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    @Enumerated(EnumType.STRING)
    private NoticeCategory category;

    @Column(columnDefinition = "TEXT")
    private String content;

    public static Notice fromNoticeDto(NoticeDto noticeDto) {
        return Notice.builder()
                .title(noticeDto.getTitle())
                .category(NoticeCategory.valueOf(noticeDto.getCategory()))
                .content(noticeDto.getContent())
                .build();
    }

    public void updateNotice(String title, NoticeCategory category, String content) {
        this.title = title;
        this.category = category;
        this.content = content;
    }
}
