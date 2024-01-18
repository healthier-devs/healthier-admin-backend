package com.healthier.admin.domain.mongo.dx.domain.dx;

import java.util.List;
import lombok.Data;

@Data
public class Cause {
    private String description; // 설명
    private List<CauseTag> tags; // 원인 태그 (제목, 내용)
}
