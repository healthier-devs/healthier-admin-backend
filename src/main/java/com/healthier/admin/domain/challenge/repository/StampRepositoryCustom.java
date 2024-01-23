package com.healthier.admin.domain.challenge.repository;

import com.healthier.admin.domain.challenge.domain.Stamp;
import com.healthier.admin.domain.challenge.domain.StampStatus;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.time.LocalDate;
import java.util.List;

public interface StampRepositoryCustom {
    Page<Stamp> findStampsByFilter(StampStatus status, LocalDate date, Pageable pageable);
}
