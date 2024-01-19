package com.healthier.admin.domain.ddx.domain.ddxQuestionList;

import com.healthier.admin.common.entity.DDxCategory;
import java.util.List;
import lombok.Getter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Document(collection = "DDxQuestionList")
public class DDxQuestionList {
    @Id private String id;

    private DDxCategory category;

    private String gender;

    private List<DDxQuestionVo> question;
}
