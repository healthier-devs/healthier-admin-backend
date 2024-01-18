package com.healthier.admin.domain.mongo.ddx.domain.ddxRatingList;

import com.healthier.admin.common.entity.DDxCategory;
import jakarta.persistence.Id;
import java.util.List;
import lombok.Getter;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Document(collection = "DDxRatingList")
public class DDxRatingList {

    @Id private String id;
    private DDxCategory category;
    private List<DDxRatingVo> result;
}
