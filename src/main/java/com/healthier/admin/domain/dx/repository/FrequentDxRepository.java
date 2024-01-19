package com.healthier.admin.domain.dx.repository;

import com.healthier.admin.domain.dx.domain.frequentDx.FrequentDx;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface FrequentDxRepository extends MongoRepository<FrequentDx, String> {}
