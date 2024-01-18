package com.healthier.admin.domain.mongo.ddx.domain.ddxAnswerList;

import java.time.LocalDate;
import lombok.Builder;
import lombok.Getter;
import org.springframework.data.mongodb.core.mapping.Field;

@Getter
@Builder
public class UserInfoVo {
    @Field(name = "name")
    private String name;

    @Field(name = "gender")
    private String gender;

    @Field(name = "birth_date")
    private LocalDate birthDate;

    @Field(name = "age")
    private int age;
}
