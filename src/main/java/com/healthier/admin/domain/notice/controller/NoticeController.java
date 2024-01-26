package com.healthier.admin.domain.notice.controller;

import com.healthier.admin.common.ApiResponse;
import com.healthier.admin.domain.notice.dto.NoticeDto;
import com.healthier.admin.domain.notice.service.NoticeService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import java.util.List;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@Tag(name = "공지사항 API", description = "공지사항 API 입니다.")
@CrossOrigin
@RequestMapping(value = "/notices")
@RequiredArgsConstructor
@RestController
@Slf4j
public class NoticeController {
    private final NoticeService noticeService;

    // Create Notice
    @Operation(summary = "공지사항 등록")
    @PostMapping
    public ApiResponse<?> createNotice(@RequestBody NoticeDto noticeDto) {
        noticeService.createNotice(noticeDto);
        return ApiResponse.DEFAULT_OK;
    }

    // Get All Notices
    @Operation(summary = "공지사항 전체 조회")
    @GetMapping
    public ApiResponse<List<NoticeDto>> getAllNotices() {
        return ApiResponse.createSuccessResponse(noticeService.getAllNotices());
    }

    // Get Notice by ID
    @Operation(summary = "공지사항 개별 조회")
    @GetMapping("/{id}")
    public ApiResponse<NoticeDto> getNotice(@PathVariable Long id) {
        return ApiResponse.createSuccessResponse(noticeService.getNotice(id));
    }

    // Update Notice
    @Operation(summary = "공지사항 수정")
    @PatchMapping("/{id}")
    public ApiResponse<?> updateNotice(@PathVariable Long id, @RequestBody NoticeDto noticeDto) {
        noticeService.updateNotice(id, noticeDto);
        return ApiResponse.DEFAULT_OK;
    }

    // Delete Notice
    @Operation(summary = "공지사항 삭제")
    @DeleteMapping("/{id}")
    public ApiResponse<?> deleteNotice(@PathVariable Long id) {
        noticeService.deleteNotice(id);
        return ApiResponse.DEFAULT_OK;
    }
}
