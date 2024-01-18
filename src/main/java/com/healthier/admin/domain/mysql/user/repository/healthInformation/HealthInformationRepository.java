package com.healthier.admin.domain.mysql.user.repository.healthInformation;

import com.healthier.admin.domain.mysql.user.domain.healthInformation.HealthInformation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HealthInformationRepository extends JpaRepository<HealthInformation, Long> {}
