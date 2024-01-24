package com.healthier.admin.domain.challenge.repository;

import com.healthier.admin.domain.challenge.domain.Stamp;
import com.healthier.admin.domain.challenge.domain.StampStatus;
import java.time.LocalDate;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface StampRepositoryCustom {
    Page<Stamp> findStampsByFilter(StampStatus status, LocalDate date, Pageable pageable);
}
