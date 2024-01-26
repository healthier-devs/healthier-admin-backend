package com.healthier.admin.domain.inquiry.controller;

import com.healthier.admin.common.ApiResponse;
import com.healthier.admin.common.dto.PageCondition;
import com.healthier.admin.common.dto.PageResponse;
import com.healthier.admin.domain.inquiry.dto.InquiryReplyDto;
import com.healthier.admin.domain.inquiry.dto.InquiryResponse;
import com.healthier.admin.domain.inquiry.service.InquiryService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springdoc.core.annotations.ParameterObject;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "문의 관리 API", description = "문의 API 입니다.")
@CrossOrigin
@RequestMapping(value = "/inquiries")
@RequiredArgsConstructor
@RestController
@Slf4j
public class InquiryController {

    private final InquiryService inquiryService;

    // 문의 리스트 (페이징)
    @Operation(summary = "문의 전체 조회")
    @GetMapping
    public ApiResponse<PageResponse<List<InquiryResponse>>> getAllInquiries(@ParameterObject PageCondition pageCondition) {
        log.info("문의 전체보기");
        return ApiResponse.createSuccessResponse(inquiryService.getAllInquiries(pageCondition));
    }

    // 문의 개별 조회
    @Operation(summary = "문의 개별 조회")
    @GetMapping("/{id}")
    public ApiResponse<InquiryResponse> getInquiry(@PathVariable Long id) {
        log.info("문의 개별보기");
        return ApiResponse.createSuccessResponse(inquiryService.getInquiry(id));
    }

    // 문의 답변 등록
    @Operation(summary = "문의 답변 등록")
    @PostMapping("/{id}")
    public ApiResponse<?> createInquiryReply(
            @PathVariable Long id, @RequestBody InquiryReplyDto inquiryReplyDto) {
        log.info("문의 답변 등록");
        inquiryService.createInquiryReply(id, inquiryReplyDto);
        return ApiResponse.DEFAULT_OK;
    }
}
