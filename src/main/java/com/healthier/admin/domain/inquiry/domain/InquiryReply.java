package com.healthier.admin.domain.inquiry.domain;

import com.healthier.admin.common.entity.BaseEntity;
import jakarta.persistence.*;
import lombok.*;

@Getter
@Entity
@Builder
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class InquiryReply extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    @JoinColumn(name = "inquiry_id")
    private Inquiry inquiry;

    @Column(columnDefinition = "TEXT")
    private String replyContent;

    public static InquiryReply of(Inquiry inquiry, String replyContent) {
        return InquiryReply.builder().inquiry(inquiry).replyContent(replyContent).build();
    }
}
