package com.geekster.restaurantManagementServiceAPI.repositories;

import com.geekster.restaurantManagementServiceAPI.models.AuthenticationToken;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

@Repository
public interface ITokenRepo extends JpaRepository <AuthenticationToken,Long>{
    AuthenticationToken findFirstByToken(String token);
}
