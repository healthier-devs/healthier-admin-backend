package com.healthier.admin.domain.mongo.dx.domain.dxRecord;

import java.time.LocalDateTime;
import java.util.List;
import lombok.Getter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Getter
@Document(collection = "DxRecord")
public class DxRecord {
    @Id private String id;

    @Field(name = "user_id")
    private Long userId;

    @Field(name = "Dx_list")
    private List<DxVo> dxList;

    @Field(name = "created_at")
    private LocalDateTime createdAt; // 진단 결과 저장 시각
}
