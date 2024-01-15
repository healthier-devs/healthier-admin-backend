package com.healthier.admin.domain.ddx.domain.ddxRatingList;

import lombok.Getter;
import org.springframework.data.mongodb.core.mapping.Field;

@Getter
public class DDxScoreVo {
    @Field(name = "answer_id")
    private int answerId;

    @Field(name = "question_id")
    private int questionId;

    @Field(name = "question_type")
    private String questionType;

    @Field(name = "color")
    private String color;
}
