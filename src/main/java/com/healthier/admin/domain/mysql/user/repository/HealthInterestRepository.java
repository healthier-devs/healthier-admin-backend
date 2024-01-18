package com.healthier.admin.domain.mysql.user.repository;

import com.healthier.admin.domain.mysql.user.domain.HealthInterest;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HealthInterestRepository extends JpaRepository<HealthInterest, Long> {}
