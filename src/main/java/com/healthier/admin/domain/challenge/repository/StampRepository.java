package com.healthier.admin.domain.challenge.repository;

import com.healthier.admin.domain.challenge.domain.Stamp;
import com.healthier.admin.domain.challenge.domain.StampStatus;
import java.time.LocalDateTime;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StampRepository extends JpaRepository<Stamp, Long> {
    List<Stamp> findByStatus(StampStatus status);

    List<Stamp> findBySubmitTimeBetween(LocalDateTime startOfDay, LocalDateTime endOfDay);

    List<Stamp> findBySubmitTimeBetweenAndStatus(
            LocalDateTime startOfDay, LocalDateTime endOfDay, StampStatus status);
}
