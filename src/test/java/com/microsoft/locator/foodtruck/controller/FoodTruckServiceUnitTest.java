package com.microsoft.locator.foodtruck.controller;

import com.microsoft.locator.foodtruck.controller.model.FoodTruckInfo;
import com.microsoft.locator.foodtruck.service.FoodTruckLocatorService;
import com.microsoft.locator.foodtruck.service.domain.FoodTruckFacility;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class FoodTruckServiceUnitTest {
    public static final String CHILLIS_CORNER = "Chillis Corner";
    public static final String MAIN_ST = "123 Main St";
    public static final String CHINESE = "Chinese";
    public static final String MOMOS_FRIED_RICE = "Momos, fried rice";
    public static final String SOME_SCHEDULE = "Some Schedule";
    public static final String APPROVED = "APPROVED";
    @Mock
    FoodTruckLocatorService foodTruckLocatorService;

    @InjectMocks
    FoodTruckService foodTruckService;

    @Test
    public void test_noTrucksFound() {
        when(foodTruckLocatorService.getClosestFoodTrucks(anyDouble(), anyDouble(), anyInt())).thenReturn(new ArrayList<>());
        List<FoodTruckInfo> closestFoodTrucks = foodTruckService.getClosestFoodTrucks(96.0, 165.0, 10);
        assertNotNull(closestFoodTrucks);
        assertTrue(closestFoodTrucks.isEmpty());
    }

    @Test
    public void test_TrucksFound() {
        List<FoodTruckFacility> foodTruckFacilities = setupFoodTruckData();
        when(foodTruckLocatorService.getClosestFoodTrucks(anyDouble(), anyDouble(), anyInt())).thenReturn(foodTruckFacilities);
        List<FoodTruckInfo> closestFoodTrucks = foodTruckService.getClosestFoodTrucks(96.0, 165.0, 10);
        assertEquals(1, closestFoodTrucks.size());
        FoodTruckInfo foodTruckInfo = closestFoodTrucks.get(0);
        assertEquals(CHILLIS_CORNER, foodTruckInfo.getName());
        assertEquals(MAIN_ST, foodTruckInfo.getAddress());
        assertEquals(CHINESE, foodTruckInfo.getType());
        assertEquals(APPROVED, foodTruckInfo.getStatus());
        assertEquals(SOME_SCHEDULE, foodTruckInfo.getSchedule());
    }

    private List<FoodTruckFacility> setupFoodTruckData() {
        List<FoodTruckFacility> foodTruckFacilities = new ArrayList<>();
        FoodTruckFacility foodTruckFacility1 = new FoodTruckFacility();
        foodTruckFacility1.setApplicant(CHILLIS_CORNER);
        foodTruckFacility1.setAddress(MAIN_ST);
        foodTruckFacility1.setFacilitytype(CHINESE);
        foodTruckFacility1.setFooditems(MOMOS_FRIED_RICE);
        foodTruckFacility1.setSchedule(SOME_SCHEDULE);
        foodTruckFacility1.setStatus(APPROVED);
        foodTruckFacilities.add(foodTruckFacility1);

        return foodTruckFacilities;
    }

}