package com.healthier.admin.domain.hospital.repository;

import com.healthier.admin.domain.hospital.domain.Hospital;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface HospitalRepository extends MongoRepository<Hospital, String> {}
