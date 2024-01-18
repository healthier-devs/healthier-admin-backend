package com.healthier.admin.domain.mongo.ddx.domain.ddxAnswerList;

import java.util.List;
import lombok.Builder;
import lombok.Getter;
import org.springframework.data.mongodb.core.mapping.Field;

@Getter
@Builder
public class UserAnswerVo {

    @Field(name = "question_id")
    private String questionId;

    @Field(name = "answer_type")
    private String answerType;

    @Field(name = "answer_id")
    private List<String> answerId;
}
