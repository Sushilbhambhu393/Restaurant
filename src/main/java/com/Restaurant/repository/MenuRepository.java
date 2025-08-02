package com.Restaurant.repository;

import com.Restaurant.model.MenuItem;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;


public interface MenuRepository extends MongoRepository<MenuItem, String> {
}