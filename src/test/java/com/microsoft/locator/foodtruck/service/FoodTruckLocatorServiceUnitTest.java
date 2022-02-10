package com.microsoft.locator.foodtruck.service;

import com.microsoft.locator.foodtruck.service.domain.FoodTruckFacility;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class FoodTruckLocatorServiceUnitTest {

    @Mock
    FoodTruckDataService foodTruckDataService;

    @InjectMocks
    FoodTruckLocatorService foodTruckLocatorService;

    @Test
    public void testClosestFoodTrucks_approved_status() {
        List<FoodTruckFacility> foodTrucks = getFoodTrucksWithStatus();
        when(foodTruckDataService.getFoodTruckFacilities()).thenReturn(foodTrucks);

        List<FoodTruckFacility> closestTrucks = foodTruckLocatorService.getClosestFoodTrucks(11.1, 150.1, 10);
        assertNotNull(closestTrucks);
        assertEquals(1, closestTrucks.size());
    }

    @Test
    public void testClosestFoodTrucks_closest() {
        List<FoodTruckFacility> foodTrucks = getFoodTrucksWithLocationDetails();
        when(foodTruckDataService.getFoodTruckFacilities()).thenReturn(foodTrucks);

        List<FoodTruckFacility> closestTrucks = foodTruckLocatorService.getClosestFoodTrucks(30.1, 11.1, 10);
        assertNotNull(closestTrucks);
        assertEquals("Taco corner", closestTrucks.get(0).getApplicant());
    }

    @Test
    public void testClosestFoodTrucks_count() {
        List<FoodTruckFacility> foodTrucks = getFoodTrucksWithStatus();
        when(foodTruckDataService.getFoodTruckFacilities()).thenReturn(foodTrucks);

        List<FoodTruckFacility> closestTrucks = foodTruckLocatorService.getClosestFoodTrucks(30.1, 11.1, 0);
        assertNotNull(closestTrucks);
        assertTrue(closestTrucks.isEmpty());
    }

    private List<FoodTruckFacility> getFoodTrucksWithStatus() {
        List<FoodTruckFacility> foodTruckFacilities = new ArrayList<>();
        FoodTruckFacility foodTruckFacility1 = new FoodTruckFacility();
        foodTruckFacility1.setStatus("Approved");
        foodTruckFacilities.add(foodTruckFacility1);

        FoodTruckFacility foodTruckFacility2 = new FoodTruckFacility();
        foodTruckFacility2.setStatus("Expired");
        foodTruckFacilities.add(foodTruckFacility2);

        FoodTruckFacility foodTruckFacility3 = new FoodTruckFacility();
        foodTruckFacility1.setLongitude(38);
        foodTruckFacility3.setStatus("Denied");
        foodTruckFacilities.add(foodTruckFacility3);

        return foodTruckFacilities;
    }

    private List<FoodTruckFacility> getFoodTrucksWithLocationDetails() {
        List<FoodTruckFacility> foodTruckFacilities = new ArrayList<>();
        FoodTruckFacility foodTruckFacility1 = new FoodTruckFacility();
        foodTruckFacility1.setApplicant("Chillys");
        foodTruckFacility1.setAddress("234 Ortega St");
        foodTruckFacility1.setLatitude(11);
        foodTruckFacility1.setLongitude(30);
        foodTruckFacility1.setStatus("Approved");
        foodTruckFacilities.add(foodTruckFacility1);

        FoodTruckFacility foodTruckFacility2 = new FoodTruckFacility();
        foodTruckFacility2.setApplicant("Taco corner");
        foodTruckFacility2.setAddress("454 Main St");
        foodTruckFacility2.setStatus("Approved");
        foodTruckFacility1.setLatitude(40);
        foodTruckFacility1.setLongitude(8);
        foodTruckFacilities.add(foodTruckFacility2);

        FoodTruckFacility foodTruckFacility3 = new FoodTruckFacility();
        foodTruckFacility3.setApplicant("Petes Coffee");
        foodTruckFacility3.setAddress("42 Salem st");
        foodTruckFacility1.setLatitude(55);
        foodTruckFacility1.setLongitude(38);
        foodTruckFacility3.setStatus("Approved");
        foodTruckFacilities.add(foodTruckFacility3);

        return foodTruckFacilities;
    }
}