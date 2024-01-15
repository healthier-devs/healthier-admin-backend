package com.healthier.admin.domain.ddx.domain.ddxQuestionList;

import java.util.List;
import lombok.Getter;

@Getter
public class DDxQuestionVo {
    private String id;

    private String question;

    private String sub_content;

    private Boolean is_multiple;

    private AnswerType answer_type;

    private String image_url;

    private List<DDxAnswerVo> answers;
}
