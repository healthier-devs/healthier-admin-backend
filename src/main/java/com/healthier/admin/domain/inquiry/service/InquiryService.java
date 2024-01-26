package com.healthier.admin.domain.inquiry.service;

import com.healthier.admin.common.dto.PageCondition;
import com.healthier.admin.common.dto.PageResponse;
import com.healthier.admin.domain.inquiry.domain.Inquiry;
import com.healthier.admin.domain.inquiry.domain.InquiryReply;
import com.healthier.admin.domain.inquiry.dto.InquiryReplyDto;
import com.healthier.admin.domain.inquiry.dto.InquiryResponse;
import com.healthier.admin.domain.inquiry.repository.InquiryReplyRepository;
import com.healthier.admin.domain.inquiry.repository.InquiryRepository;
import java.util.List;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Slf4j
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class InquiryService {

    private final InquiryRepository inquiryRepository;
    private final InquiryReplyRepository inquiryReplyRepository;

    // 문의 리스트 (페이징)
    public PageResponse<List<InquiryResponse>> getAllInquiries(PageCondition pageCondition) {
        Pageable pageable = PageRequest.of(pageCondition.getPage(), pageCondition.getSize());
        Page<Inquiry> inquiries = inquiryRepository.findAll(pageable);
        List<InquiryResponse> inquiryResponses =
                inquiries.stream().map(InquiryResponse::fromPreview).toList();
        return new PageResponse<>(inquiryResponses, inquiries.getTotalElements());
    }

    // 문의 개별 조회
    public InquiryResponse getInquiry(Long id) {
        return inquiryRepository
                .findById(id)
                .map(InquiryResponse::fromDetail)
                .orElseThrow(() -> new IllegalArgumentException("존재하지 않는 문의입니다."));
    }

    // 문의 답변 등록
    @Transactional
    public void createInquiryReply(Long id, InquiryReplyDto inquiryReplyDto) {
        Inquiry inquiry =
                inquiryRepository
                        .findById(id)
                        .orElseThrow(() -> new IllegalArgumentException("존재하지 않는 문의입니다."));
        if (inquiry.isAnswered()) {
            throw new IllegalStateException("이미 답변이 등록된 문의입니다.");
        }
        InquiryReply inquiryReply = InquiryReply.of(inquiry, inquiryReplyDto.getContent());
        inquiryReplyRepository.save(inquiryReply);
        inquiry.setReply(inquiryReply);
        inquiry.updateIsAnswered();
        inquiryRepository.save(inquiry);
    }
}
