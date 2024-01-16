package com.healthier.admin.domain.ddx.repository;

import com.healthier.admin.domain.ddx.domain.ddxRatingList.DDxRatingList;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface DDxRatingListRepository extends MongoRepository<DDxRatingList, String> {}
