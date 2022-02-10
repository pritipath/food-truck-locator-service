package com.microsoft.locator.foodtruck.controller;

import com.microsoft.locator.foodtruck.controller.model.FoodTruckInfo;
import com.microsoft.locator.foodtruck.service.FoodTruckLocatorService;
import com.microsoft.locator.foodtruck.service.domain.FoodTruckFacility;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import java.util.List;

@RestController
@Validated
public class FoodTruckService {
    @Autowired
    private FoodTruckLocatorService foodTruckLocatorService;

    @GetMapping("/foodtrucks/closest")
    public List<FoodTruckInfo> getClosestFoodTrucks(@RequestParam
                                                    @Min(value = -90)
                                                    @Max(value = 90)
                                                            double latitude,
                                                    @RequestParam
                                                    @Min(value = -180, message = "longitude must be greater than or equal to -180")
                                                    @Max(value = 180, message = "longitude must be less than or equal to 180" )
                                                            double longitude,
                                                    @RequestParam
                                                            int foodTruckCount) {
        List<FoodTruckFacility> foodTruckFacilities = foodTruckLocatorService.getClosestFoodTrucks(latitude, longitude, foodTruckCount);
        return FoodTruckDomainTransformer.mapDomainObjectToDTO(foodTruckFacilities);
    }

}
