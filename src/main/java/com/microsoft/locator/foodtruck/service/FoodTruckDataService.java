package com.microsoft.locator.foodtruck.service;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.microsoft.locator.foodtruck.service.domain.FoodTruckFacility;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@Slf4j
@Service
public class FoodTruckDataService {
    private List<FoodTruckFacility> foodTruckFacilities = new ArrayList<>();

    @Value("${foodtruck.data.url}")
    private String foodTruckDataUrl;

    private RestTemplate restTemplate = new RestTemplate();

    @PostConstruct
    private void setup() {
        try {
            initFoodTruckList();
        } catch(Exception e) {
            log.error("Failed to get Food truck info", e);
        }
    }

    private void initFoodTruckList() {
        List<FoodTruckFacility> foodTrucks
                = restTemplate.getForObject(foodTruckDataUrl, List.class);
        foodTruckFacilities = new ObjectMapper().convertValue(foodTrucks, new TypeReference<>() { });
    }

    public List<FoodTruckFacility> getFoodTruckFacilities() {
        return foodTruckFacilities;
    }
}
