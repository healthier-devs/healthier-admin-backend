package com.healthier.admin.domain.mongo.hospital.repository;

import com.healthier.admin.domain.mongo.hospital.domain.MedicalFacility;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface MedicalFacilityRepository extends MongoRepository<MedicalFacility, String> {}
