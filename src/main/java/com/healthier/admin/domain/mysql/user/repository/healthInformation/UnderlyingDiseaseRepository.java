package com.healthier.admin.domain.mysql.user.repository.healthInformation;

import com.healthier.admin.domain.mysql.user.domain.healthInformation.UnderlyingDisease;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UnderlyingDiseaseRepository extends JpaRepository<UnderlyingDisease, Long> {}
