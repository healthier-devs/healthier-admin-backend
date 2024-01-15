package com.healthier.admin.common.entity;

public enum DDxCategory {

    /** 치과 * */
    TOOTH("Tooth Pain", "치통"), // 치아
    GUM("Gingiva Pain", "잇몸 통증"), // 잇몸
    TLM("Tongue/Lip Pain", "혀 입술 점막 통증"), // 혀/입술/점막
    TJT("TMJ Pain", "턱관절/관자놀이 통증"), // 턱관절/관자놀이

    /** 소화기 * */
    STOMACH("Abdominal Pain", "배가 아파요"), // 급성복통
    INDIGESTION("Dyspepsia, Abdominal Discomfort", "소화가 안돼요, 배가 불편해요"), // 만성복통
    HEMATEMESIS("Hematemesis", "피를 토해요"), // 토혈
    BLOODYSTOOL(
            "Melena (-), Hematochezia (-)", "변에서 피가 나와요"), // 혈변  Todo: 예외처리 필요 (답변에 따라 name 달라짐)
    VOMIT("Vomiting", "구토를 해요"), // 구토
    DIARRHEA("Diarrhea", "설사를 해요"), // 배변이상(설사)
    CONSTIPATION("Constipation", "변 보기 힘들어요"), // 배변이상(변비)
    JAUNDICE("Jaundice", "몸이 노랗게 되었어요"), // 황달

    /** 호흡기 * */
    COUGH("Cough", "기침"), // 기침
    RHINORRHEA("Rhinorrhea", "콧물, 코막힘"), // 콧물, 코막힘
    DYSPNEA("dyspnea", "호흡곤란"), // 호흡곤란

    /** 순환기 * */
    CHESTPAIN("Chest Pain", "가슴통증"), // 가슴통증
    SYNCOPE("syncope", "실신"), // 실신
    PALPITATION("palpitation", "두근거림"), // 두근거림
    HYPERTENSION("hypertension", "고혈압"), // 고혈압
    DYSLIPIDEMIA("dyslipidemia", "이상지질혈증"), // 이상지질혈증

    /** 신장/비뇨 * */
    POLYURIA("Polyuria", "다뇨"), // 다뇨
    HEMATURIA("hematuria", "혈뇨"), // 혈뇨
    OLIGOURIA("oligouria", "핍뇨"), // 핍뇨
    FUNDHIS("fundhis", "배뇨이상"), // 배뇨이상

    /** 전신 * */
    FEVER("Fever", "발열"), // 발열
    BRUISE("Bruise", "멍"), // 멍
    FATIGUE("Fatigue", "피로"), // 피로
    WEIGHTLOOSE("Weight Loose", "체중 감소"), // 체중감소
    WEIGHTGAIN("Weight Gain", "체중 증가/비만"), // 체중증가/비만

    /** 근골격 피부감각기 * */
    ARTHALGIA("Arthalgia", "관절 통증/부기"), // 관절 통증/부기
    NECKPAIN("Neckpain", "목통증"), // 목통증
    BACKPAIN("Backpain", "허리가 아파요"), // 허리통증
    RASH("Rash", "피부발진"), // 피부발진

    /** 정신 * */
    MOODCHANGE("mood change", "기분 변화"), // 기분 변화
    ANXIETY("Anxiety", "불안"), // 불안
    SLEEP("Sleep", "수면 장애"), // 수면장애
    DEMENTIA("Dementia", "기억력 저하"), // 기억력 저하

    /** 신경 * */
    DIZZINESS("Dizziness", "어지러움"), // 어지러움
    HEADACHE("Headache", "두통"), // 두통
    SEIZURE("Seizure", "경련"), // 경련
    SENSE("Sense", "근력/감각 이상"), // 근력/감각 이상
    CONSCIOUSNESS("Consciousness", "의식 장애"), // 의식 장애
    TREMOR("Tremor", "떨림/운동 이상"); // 떨림/ 운동 이상

    private final String name;
    private final String CC;

    DDxCategory(String name, String CC) {
        this.name = name;
        this.CC = CC;
    }

    public String getName() {
        return name;
    }

    public String getCC() {
        return CC;
    }
}
