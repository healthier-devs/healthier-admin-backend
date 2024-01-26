package com.healthier.admin.inquiry;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import com.healthier.admin.domain.inquiry.domain.Inquiry;
import com.healthier.admin.domain.inquiry.domain.InquiryCategory;
import com.healthier.admin.domain.inquiry.domain.InquiryReply;
import com.healthier.admin.domain.inquiry.dto.InquiryReplyDto;
import com.healthier.admin.domain.inquiry.dto.InquiryResponse;
import com.healthier.admin.domain.inquiry.repository.InquiryReplyRepository;
import com.healthier.admin.domain.inquiry.repository.InquiryRepository;
import com.healthier.admin.domain.inquiry.service.InquiryService;
import java.util.Optional;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

public class InquiryServiceTest {
    @Mock private InquiryRepository inquiryRepository;

    @Mock private InquiryReplyRepository inquiryReplyRepository;

    @InjectMocks private InquiryService inquiryService;

    private Long inquiryId = 1L;
    private Inquiry inquiry;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);

        // Mocking
        inquiry =
                Inquiry.builder()
                        .id(inquiryId)
                        .title("건강챌린지 문의")
                        .content("건강챌린지 문의합니다.")
                        .category(InquiryCategory.CHALLENGE)
                        .isAnswered(false)
                        .build();

        when(inquiryRepository.findById(inquiryId)).thenReturn(Optional.of(inquiry));
    }

    @Test
    void getInquiry() {
        // Test
        InquiryResponse result = inquiryService.getInquiry(inquiryId);

        // Assertions
        assertEquals(inquiryId, result.getId());
        assertEquals(inquiry.getTitle(), result.getTitle());
        assertEquals(inquiry.getContent(), result.getContent());
        assertEquals(inquiry.getCategory().getName(), result.getCategory());
    }

    @Test
    void createInquiryReply() {
        InquiryReplyDto inquiryReplyDto = InquiryReplyDto.builder().content("답변입니다").build();

        // Test
        assertDoesNotThrow(() -> inquiryService.createInquiryReply(inquiryId, inquiryReplyDto));

        // Assertions
        verify(inquiryReplyRepository, times(1)).save(any(InquiryReply.class));
        assertTrue(inquiry.isAnswered());
        assertEquals(inquiryReplyDto.getContent(), inquiry.getReply().getReplyContent());
    }
}
