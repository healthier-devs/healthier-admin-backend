package com.healthier.admin.domain.mongo.dx.domain.dxRecord;

import lombok.Getter;
import org.springframework.data.mongodb.core.mapping.Field;

@Getter
public class DxVo {
    @Field(name = "Dx_id")
    private Long dxId;

    @Field(name = "Dx_name")
    private String dxName;
}
