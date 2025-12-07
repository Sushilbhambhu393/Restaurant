package com.Restaurant.service;

import com.Restaurant.model.Order;
import com.Restaurant.repository.IOrderRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {
    @Autowired
    private IOrderRepo orderRepo;

    public Order placeOrder(Order order) {
        order.calculateTotalPrice();
        return orderRepo.save(order);
    }

    public List<Order> getOrderHistory(String userId) {
        return orderRepo.findByUserId(userId);
    }

}