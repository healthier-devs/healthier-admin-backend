package com.healthier.admin.domain.dx.domain.frequentDx;

import java.util.List;
import lombok.Getter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Getter
@Document(collection = "FrequentDx")
public class FrequentDx {
    @Id private String id;

    private String name; // 진단명

    @Field(name = "age_groups")
    private List<Integer> ageGroups; // 자주 발생하는 나잇대

    private String image; // 배너 이미지 url
}
