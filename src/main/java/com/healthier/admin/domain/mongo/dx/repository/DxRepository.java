package com.healthier.admin.domain.mongo.dx.repository;

import com.healthier.admin.domain.mongo.dx.domain.dx.Dx;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface DxRepository extends MongoRepository<Dx, Long> {}
