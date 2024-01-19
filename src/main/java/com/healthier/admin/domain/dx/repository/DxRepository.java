package com.healthier.admin.domain.dx.repository;

import com.healthier.admin.domain.dx.domain.dx.Dx;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface DxRepository extends MongoRepository<Dx, Long> {}
