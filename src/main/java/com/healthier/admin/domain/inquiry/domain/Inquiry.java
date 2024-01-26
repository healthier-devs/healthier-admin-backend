package com.healthier.admin.domain.inquiry.domain;

import com.healthier.admin.common.entity.BaseEntity;
import com.healthier.admin.domain.user.domain.User;
import jakarta.persistence.*;
import java.util.List;
import lombok.*;

@Getter
@Entity
@Builder
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Inquiry extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    @OneToOne(mappedBy = "inquiry", cascade = CascadeType.ALL)
    private InquiryReply reply;

    @Enumerated(EnumType.STRING)
    private InquiryCategory category;

    private String title;

    @Column(columnDefinition = "TEXT")
    private String content;

    private boolean isAnswered;

    @OneToMany(
            mappedBy = "inquiry",
            cascade = CascadeType.ALL,
            orphanRemoval = true,
            fetch = FetchType.LAZY)
    private List<InquiryImage> images;

    public void updateIsAnswered() {
        this.isAnswered = true;
    }

    public void setReply(InquiryReply reply) {
        this.reply = reply;
    }
}
