package com.healthier.admin.domain.mongo.ddx.repository;

import com.healthier.admin.domain.mongo.ddx.domain.ddxRatingList.DDxRatingList;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface DDxRatingListRepository extends MongoRepository<DDxRatingList, String> {}
