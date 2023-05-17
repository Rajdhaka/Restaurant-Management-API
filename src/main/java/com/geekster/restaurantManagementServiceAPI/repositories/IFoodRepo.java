package com.geekster.restaurantManagementServiceAPI.repositories;

import com.geekster.restaurantManagementServiceAPI.models.Food;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IFoodRepo extends JpaRepository<Food,Long> {
}
