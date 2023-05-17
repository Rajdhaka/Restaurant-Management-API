package com.geekster.restaurantManagementServiceAPI.services;

import com.geekster.restaurantManagementServiceAPI.models.Food;
import com.geekster.restaurantManagementServiceAPI.repositories.IFoodRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FoodService {
    @Autowired
    IFoodRepo foodRepo;
    public void saveFood(Food food) {
        foodRepo.save(food);
    }

    public void deleteFood(Long foodId){
        foodRepo.deleteById(foodId);
    }

    public List<Food> getMenu() {
        return foodRepo.findAll();
    }
}
