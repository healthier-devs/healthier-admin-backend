package com.healthier.admin.domain.notice.service;

import com.healthier.admin.domain.notice.domain.Notice;
import com.healthier.admin.domain.notice.domain.NoticeCategory;
import com.healthier.admin.domain.notice.dto.NoticeDto;
import com.healthier.admin.domain.notice.repository.NoticeRepository;
import java.util.List;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class NoticeService {
    private final NoticeRepository noticeRepository;

    // Create Notice
    @Transactional
    public void createNotice(NoticeDto noticeDto) {
        Notice notice = Notice.fromNoticeDto(noticeDto);
        noticeRepository.save(notice);
    }

    // Get All Notices
    public List<NoticeDto> getAllNotices() {
        return noticeRepository.findAll().stream()
                .map(NoticeDto::fromPreview)
                .collect(Collectors.toList());
    }

    // Get Notice by ID
    public NoticeDto getNotice(Long id) {
        return noticeRepository
                .findById(id)
                .map(NoticeDto::fromDetail)
                .orElseThrow(() -> new IllegalArgumentException("해당 공지사항이 존재하지 않습니다."));
    }

    // Update Notice
    @Transactional
    public void updateNotice(Long id, NoticeDto noticeDto) {
        Notice updatedNotice =
                noticeRepository
                        .findById(id)
                        .map(
                                notice -> {
                                    notice.updateNotice(
                                            noticeDto.getTitle(),
                                            NoticeCategory.valueOf(noticeDto.getCategory()),
                                            noticeDto.getContent());
                                    return notice;
                                })
                        .orElseThrow(() -> new IllegalArgumentException("해당 공지사항이 존재하지 않습니다."));

        noticeRepository.save(updatedNotice);
    }

    // Delete Notice
    @Transactional
    public void deleteNotice(Long id) {
        noticeRepository.deleteById(id);
    }
}
