package com.geekster.restaurantManagementServiceAPI.services;

import com.geekster.restaurantManagementServiceAPI.models.Order;
import com.geekster.restaurantManagementServiceAPI.models.User;
import com.geekster.restaurantManagementServiceAPI.repositories.IOrderRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {
    @Autowired
    IOrderRepo orderRepo;
    public void postOrder(Order order) {
        orderRepo.save(order);
    }

    public List<Order> getUserAllOrder(Long userId) {
       List<Order>allOrder = orderRepo.findAllOrder(userId);
       return  allOrder;
    }

    public void deleteOrder(Long orderId) {
        orderRepo.deleteById(orderId);
    }
}
