package com.healthier.admin.domain.user.repository.healthInformation;

import com.healthier.admin.domain.user.domain.healthInformation.UnderlyingDisease;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UnderlyingDiseaseRepository extends JpaRepository<UnderlyingDisease, Long> {}
