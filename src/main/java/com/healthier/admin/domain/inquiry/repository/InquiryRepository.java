package com.healthier.admin.domain.inquiry.repository;

import com.healthier.admin.domain.inquiry.domain.Inquiry;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InquiryRepository extends JpaRepository<Inquiry, Long> {}
