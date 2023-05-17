package com.geekster.restaurantManagementServiceAPI.repositories;

import com.geekster.restaurantManagementServiceAPI.models.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;

@Repository
public interface IOrderRepo extends JpaRepository<Order,Long> {
    @Query(value = "select * from orders where fk_user_user_id=:userId",nativeQuery = true)
    List<Order> findAllOrder(Long userId);
}
