package com.healthier.admin.domain.mysql.serviceTerms.repository;

import com.healthier.admin.domain.mysql.serviceTerms.domain.ServiceTerms;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ServiceTermsRepository extends JpaRepository<ServiceTerms, Long> {}
