package com.microsoft.locator.foodtruck.service.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class FoodTruckFacility {
    private long objectid;
    private String applicant;
    private String facilitytype;
    private String address;
    private String status;
    private String fooditems;
    private double latitude;
    private double longitude;
    private String cnn;
    private String locationdescription;
    private String permit;
    private String schedule;
    private String approved;
    private String expirationdate;
}
