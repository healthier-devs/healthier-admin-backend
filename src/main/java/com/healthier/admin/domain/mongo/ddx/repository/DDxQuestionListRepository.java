package com.healthier.admin.domain.mongo.ddx.repository;

import com.healthier.admin.domain.mongo.ddx.domain.ddxQuestionList.DDxQuestionList;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface DDxQuestionListRepository extends MongoRepository<DDxQuestionList, String> {}
