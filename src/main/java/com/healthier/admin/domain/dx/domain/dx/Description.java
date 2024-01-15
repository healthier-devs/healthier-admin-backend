package com.healthier.admin.domain.dx.domain.dx;

import java.util.List;
import lombok.Data;

@Data
public class Description {
    private String title; // 질환설명 제목
    private String content; // 질환설명 내용
    private List<String> keySymptom; // 주요 증상
}
