package com.healthier.admin.domain.mongo.dx.repository;

import com.healthier.admin.domain.mongo.dx.domain.frequentDx.FrequentDx;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface FrequentDxRepository extends MongoRepository<FrequentDx, String> {}
