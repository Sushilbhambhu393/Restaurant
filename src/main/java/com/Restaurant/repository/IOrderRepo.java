package com.Restaurant.repository;

import com.Restaurant.model.Order;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface IOrderRepo extends MongoRepository<Order, String> {
    List<Order> findByUserId(String userId);
}