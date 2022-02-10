package com.microsoft.locator.foodtruck.controller.model;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class FoodTruckInfo {
    private String name;
    private String type;
    private String address;
    private String status;
    private String foodItems;
    private String schedule;
}
