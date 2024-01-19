package com.healthier.admin.domain.notice.repository;

import com.healthier.admin.domain.notice.domain.Notice;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NoticeRepository extends JpaRepository<Notice, Long> {}
