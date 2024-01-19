package com.healthier.admin.domain.ddx.domain.ddxAnswerList;

import com.healthier.admin.common.entity.DDxCategory;
import java.time.LocalDateTime;
import java.util.List;
import lombok.Getter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Getter
@Document(collection = "DDxAnswerList")
public class DDxAnswerList {
    @Id private String id;

    @Field(name = "name")
    private String name;

    private List<UserAnswerVo> answer; // 답변 리스트

    @Field(name = "dx_id_list")
    private List<Long> dxIdList; // 진단 결과 리스트

    @Field(name = "created_at")
    private LocalDateTime createdAt;

    private DDxCategory category;

    private String username;

    @Field(name = "user_info")
    private UserInfoVo userInfo;
}
