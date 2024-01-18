package com.healthier.admin.domain.mongo.ddx.repository;

import com.healthier.admin.domain.mongo.ddx.domain.ddxAnswerList.DDxAnswerList;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface DDxAnswerListRepository extends MongoRepository<DDxAnswerList, String> {}
