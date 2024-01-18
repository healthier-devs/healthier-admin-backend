package com.healthier.admin.domain.mongo.hospital.domain;

import jakarta.persistence.Id;
import java.util.List;
import lombok.Getter;
import lombok.ToString;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@ToString
@Document(collection = "Hospital")
public class Hospital {
    @Id private String id;

    private int doctorDnt;

    private String homepage;
    private String nearbyPublicBuilding;
    private String direction;
    private String distance;
    private Integer parkingSpace;
    private String parkingFee;
    private String parkingExtraInfo;
    private String emergencyNightPhone;
    private List<SpecialTreatment> specialTreatment;
    private List<Equipment> equipment;
    private List<ExcellentAgency> excellentAgency;

    @Getter
    public static class SpecialTreatment {
        private String name;
    }

    @Getter
    public static class Equipment {
        private String name;
    }

    @Getter
    public static class ExcellentAgency {
        private String name;
        private String grade;
    }
}
