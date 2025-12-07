package com.Restaurant.repository;

import com.Restaurant.model.MenuItem;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface IFoodRepo extends MongoRepository<MenuItem, String> {
    boolean existsByName(String name);
}