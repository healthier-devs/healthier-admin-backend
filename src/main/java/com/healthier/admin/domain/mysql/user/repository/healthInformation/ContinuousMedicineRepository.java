package com.healthier.admin.domain.mysql.user.repository.healthInformation;

import com.healthier.admin.domain.mysql.user.domain.healthInformation.ContinuousMedicine;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContinuousMedicineRepository extends JpaRepository<ContinuousMedicine, Long> {}
