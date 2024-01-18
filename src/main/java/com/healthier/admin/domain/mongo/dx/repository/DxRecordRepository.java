package com.healthier.admin.domain.mongo.dx.repository;

import com.healthier.admin.domain.mongo.dx.domain.dxRecord.DxRecord;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface DxRecordRepository extends MongoRepository<DxRecord, String> {}
