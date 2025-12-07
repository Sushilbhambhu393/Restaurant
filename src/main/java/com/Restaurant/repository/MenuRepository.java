package com.Restaurant.repository;

import com.Restaurant.model.Menu;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MenuRepository extends MongoRepository<Menu, Integer> {
    // Custom queries can be added later if needed
}