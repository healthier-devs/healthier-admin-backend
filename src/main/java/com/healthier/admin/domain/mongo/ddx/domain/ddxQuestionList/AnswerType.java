package com.healthier.admin.domain.mongo.ddx.domain.ddxQuestionList;

public enum AnswerType {
    DEF("DEF"),
    ETC("ETC"),
    IMG("IMG"),
    NUMBER_1("NUMBER_1"),
    DRAG_1("DRAG_1"),
    STR("STR"),
    NA("NA"),

    /* 삭제 */
    NUMBER_2("NUMBER_2"),
    NUMBER_3("NUMBER_3"),
    NUMBER_4("NUMBER_4"),
    NUMBER_5("NUMBER_5"),
    NUMBER_6("NUMBER_6"),
    NUMBER_7("NUMBER_7"),
    NUMBER_8("NUMBER_8"),
    NUMBER_9("NUMBER_9"),
    NUMBER_10("NUMBER_10"),
    NUMBER_11("NUMBER_11");

    private final String name;

    AnswerType(String name) {
        this.name = name;
    }
}
