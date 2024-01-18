package com.healthier.admin.domain.mysql.inquiry.repository;

import com.healthier.admin.domain.mysql.inquiry.domain.Inquiry;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InquiryRepository extends JpaRepository<Inquiry, Long> {}
