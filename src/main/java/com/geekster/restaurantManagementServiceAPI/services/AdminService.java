package com.geekster.restaurantManagementServiceAPI.services;

import com.geekster.restaurantManagementServiceAPI.models.Admin;
import com.geekster.restaurantManagementServiceAPI.models.Food;
import com.geekster.restaurantManagementServiceAPI.repositories.IAdminRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdminService {
    @Autowired
    IAdminRepo adminRepo;

    @Autowired
    FoodService foodService;
    public void addAdmin(Admin admin) {
        adminRepo.save(admin);
    }

    public void addFood(String adminEmail, Food food) {
        Admin admin = adminRepo.findByAdminEmail(adminEmail);

        if(admin ==null){
            throw new IllegalStateException("Admin does not exist");
        }
        else{
            foodService.saveFood(food);
        }
    }

    public void removeFoodById(String adminEmail, Long foodId) {
        Admin admin = adminRepo.findByAdminEmail(adminEmail);
        if(admin ==null){
            throw new IllegalStateException("Admin does not exist");
        }
        foodService.deleteFood(foodId);
    }
}
