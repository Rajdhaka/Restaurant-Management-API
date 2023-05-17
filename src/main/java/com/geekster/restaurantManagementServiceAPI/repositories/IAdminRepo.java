package com.geekster.restaurantManagementServiceAPI.repositories;

import com.geekster.restaurantManagementServiceAPI.models.Admin;
import com.geekster.restaurantManagementServiceAPI.services.AdminService;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IAdminRepo extends JpaRepository<Admin,Long> {
    Admin findByAdminEmail(String adminEmail);
}
