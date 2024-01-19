package com.healthier.admin.domain.user.repository.healthInformation;

import com.healthier.admin.domain.user.domain.healthInformation.Medicine;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MedicineRepository extends JpaRepository<Medicine, Long> {}
