package com.healthier.admin.notice;

import com.healthier.admin.domain.notice.domain.Notice;
import com.healthier.admin.domain.notice.domain.NoticeCategory;
import com.healthier.admin.domain.notice.dto.NoticeDto;
import com.healthier.admin.domain.notice.repository.NoticeRepository;
import com.healthier.admin.domain.notice.service.NoticeService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockedStatic;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class NoticeServiceTest {

    @Mock
    private NoticeRepository noticeRepository;

    @InjectMocks
    private NoticeService noticeService;

    private Notice notice1, notice2;
    private NoticeDto noticeDto1, noticeDto2;

    @BeforeEach
    void setUp() {
        notice1 =
            Notice.builder()
                .id(1L)
                .title("공지사항1")
                .category(NoticeCategory.NOTICE)
                .content("공지사항1 내용")
                .build();

        notice2 =
            Notice.builder()
                .id(2L)
                .title("공지사항2")
                .category(NoticeCategory.REWARD)
                .content("공지사항2 내용")
                .build();

        noticeDto1 =
            NoticeDto.builder()
                .title("공지사항1")
                .category("NOTICE")
                .content("공지사항1 내용")
                .build();

        noticeDto2 =
            NoticeDto.builder()
                .title("공지사항2")
                .category("REWARD")
                .content("공지사항2 내용")
                .build();
    }

    @DisplayName("Create Notice")
    @Test
    void createNoticeTest() {
        try (MockedStatic<Notice> mockedStatic = Mockito.mockStatic(Notice.class)) {
            // Given
            mockedStatic.when(() -> Notice.fromNoticeDto(noticeDto1)).thenReturn(notice1);

            // When
            noticeService.createNotice(noticeDto1);

            // Then
            verify(noticeRepository).save(notice1);
        }
    }

    @DisplayName("Get All Notices")
    @Test
    void getAllNoticesTest() {
        // Given
        when(noticeRepository.findAll()).thenReturn(Arrays.asList(notice1, notice2));

        // When
        List<NoticeDto> result = noticeService.getAllNotices();

        // Then
        assertEquals(2, result.size());
    }

    @DisplayName("Get Notice by ID")
    @Test
    void getNoticeTest() {
        // Given
        Long id = 1L;
        when(noticeRepository.findById(id)).thenReturn(Optional.of(notice1));

        // When
        NoticeDto result = noticeService.getNotice(id);

        // Then
        assertNotNull(result);
        assertEquals(notice1.getId(), result.getId());
        assertEquals(notice1.getTitle(), result.getTitle());
    }

    @DisplayName("Update Notice")
    @Test
    void updateNoticeTest() {
        // Given
        Long id = 1L;
        when(noticeRepository.findById(id)).thenReturn(Optional.of(notice1));

        // When
        noticeService.updateNotice(id, noticeDto1);

        // Then
        verify(noticeRepository).save(notice1);
    }

    @DisplayName("Delete Notice")
    @Test
    void deleteNoticeTest() {
        // Given
        Long id = 1L;

        // When
        noticeService.deleteNotice(id);

        // Then
        verify(noticeRepository).deleteById(id);
    }
}
