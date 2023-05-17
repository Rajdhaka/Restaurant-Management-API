package com.geekster.restaurantManagementServiceAPI.services;

import com.geekster.restaurantManagementServiceAPI.models.Food;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ViewerService {

    @Autowired
    FoodService foodService;
    public List<Food> getMenu() {
       return foodService.getMenu();
    }
}
