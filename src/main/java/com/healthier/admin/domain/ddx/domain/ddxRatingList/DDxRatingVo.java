package com.healthier.admin.domain.ddx.domain.ddxRatingList;

import java.util.List;
import lombok.Getter;
import org.springframework.data.mongodb.core.mapping.Field;

@Getter
public class DDxRatingVo {
    @Field(name = "name")
    private String name;

    @Field(name = "dx_id")
    private Long dxId;

    @Field(name = "score")
    private List<DDxScoreVo> score;
}
