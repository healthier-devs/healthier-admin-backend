package com.healthier.admin.domain.mongo.hospital.domain;

import java.util.List;
import java.util.Map;
import lombok.Getter;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.geo.Point;
import org.springframework.data.mongodb.core.index.GeoSpatialIndexType;
import org.springframework.data.mongodb.core.index.GeoSpatialIndexed;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@ToString
@Document(collection = "MedicalFacility")
public class MedicalFacility {
    @Id private String id;

    private String name;

    private String type;
    private Integer typeCode;
    private String phoneNumber;
    private String province;
    private String city;
    private String town;
    private Integer zipcode;
    private String establishedDate;
    private String address;

    private String emergencyNight;
    private Map<String, TimeSlot> schedule;

    @GeoSpatialIndexed(type = GeoSpatialIndexType.GEO_2DSPHERE)
    private Point location;

    private List<Department> department;
    private String nightService;

    @Getter
    public static class TimeSlot {
        private String start;
        private String end;
    }

    @Getter
    public static class Department {
        private String name;
        private String count;
    }
}
