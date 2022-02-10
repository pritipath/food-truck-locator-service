package com.microsoft.locator.foodtruck.controller;

import com.microsoft.locator.foodtruck.controller.model.FoodTruckInfo;
import com.microsoft.locator.foodtruck.service.domain.FoodTruckFacility;

import java.util.List;
import java.util.stream.Collectors;

public class FoodTruckDomainTransformer {
    public static List<FoodTruckInfo> mapDomainObjectToDTO(List<FoodTruckFacility> foodTruckFacilities) {

        return foodTruckFacilities.stream().map((foodTruck -> {

            FoodTruckInfo foodTruckInfo = new FoodTruckInfo();
            foodTruckInfo.setName(foodTruck.getApplicant());
            foodTruckInfo.setAddress(foodTruck.getAddress());
            foodTruckInfo.setFoodItems(foodTruck.getFooditems());
            foodTruckInfo.setType(foodTruck.getFacilitytype());
            foodTruckInfo.setSchedule(foodTruck.getSchedule());
            foodTruckInfo.setStatus(foodTruck.getStatus());
            return foodTruckInfo;
        }
        )).collect(Collectors.toList());

    }
}
