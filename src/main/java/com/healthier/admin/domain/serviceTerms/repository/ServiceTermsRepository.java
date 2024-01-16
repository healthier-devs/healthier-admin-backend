package com.healthier.admin.domain.serviceTerms.repository;

import com.healthier.admin.domain.serviceTerms.domain.ServiceTerms;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ServiceTermsRepository extends JpaRepository<ServiceTerms, Long> {}
