package com.microsoft.locator.foodtruck.service;

import com.microsoft.locator.foodtruck.service.domain.FoodTruckFacility;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

@Slf4j
@Service
public class FoodTruckLocatorService {
   @Autowired
   private FoodTruckDataService foodTruckDataService;

   public List<FoodTruckFacility> getClosestFoodTrucks(double inputLatitude, double inputLongitude, int numFacilties) {
        Comparator<FoodTruckFacility> locationComparator =
                Comparator.comparing(f1-> (f1.getLatitude() - inputLatitude) * (f1.getLatitude() -inputLatitude)
                                        + (f1.getLongitude() - inputLongitude) * (f1.getLongitude() -inputLongitude));

        List<FoodTruckFacility> approvedFoodTrucks
                = foodTruckDataService.getFoodTruckFacilities().stream().filter(isStatusValid).collect(Collectors.toList());

        Collections.sort(approvedFoodTrucks, locationComparator);
        numFacilties = numFacilties > approvedFoodTrucks.size() ? approvedFoodTrucks.size() : numFacilties;
        return approvedFoodTrucks.isEmpty() ? approvedFoodTrucks : approvedFoodTrucks.subList(0, numFacilties);

   }

   Predicate<FoodTruckFacility> isStatusValid = facility -> facility.getStatus().equalsIgnoreCase("APPROVED");
}
