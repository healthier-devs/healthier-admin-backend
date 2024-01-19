package com.healthier.admin.domain.ddx.repository;

import com.healthier.admin.domain.ddx.domain.ddxQuestionList.DDxQuestionList;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface DDxQuestionListRepository extends MongoRepository<DDxQuestionList, String> {}
