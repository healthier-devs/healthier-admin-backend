package com.healthier.admin.domain.mongo.ddx.domain.ddxQuestionList;

import lombok.Getter;
import org.springframework.data.mongodb.core.mapping.Field;

@Getter
public class DDxAnswerVo {
    @Field(name = "answer_id")
    private String answerId;

    private String answer;

    @Field(name = "next_question")
    private DDxQuestionVo nextQuestion;
}
