package com.healthier.admin.domain.dx.domain.dx;

import com.healthier.admin.common.entity.DDxCategory;
import java.util.List;
import lombok.Getter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Getter
@Document(collection = "Dx")
public class Dx {
    @Id private Long id;

    private DDxCategory category; // category enum (무증상 로직에서 사용)

    @Field(name = "main_category")
    private String mainCategory; // 대분류

    @Field(name = "sub_category")
    private String subCategory; // 소분류

    private String name; // 진단명

    @Field(name = "typical_symptom")
    private String typicalSymptom; // 대표증상

    @Field(name = "necessary_measures")
    private String necessaryMeasures; // 필요한 조치

    // TODO : 진료과 Enum
    @Field(name = "medical_departments")
    private List<String> medicalDepartments; // 진료과

    private int severity; // 중증도
    private Description description; // 질환설명 (제목, 내용, 주요 증상)
    private Cause cause; // 원인

    @Field(name = "lifestyle_habits")
    private List<LifestyleHabit> lifestyleHabits; // 생활습관

    private List<Medicine> medicines; // 약

    @Field(name = "examination_treatments")
    private List<ExaminationTreatment> examinationTreatments; // 검사/치료

    @Field(name = "main_img")
    private String mainImg; // 메인 이미지

    @Field(name = "banner_img")
    private String bannerImg; // 베너 이미지
}
