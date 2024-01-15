package com.healthier.admin.domain.hospital.repository;

import com.healthier.admin.domain.hospital.domain.MedicalFacility;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface MedicalFacilityRepository extends MongoRepository<MedicalFacility, String> {}
