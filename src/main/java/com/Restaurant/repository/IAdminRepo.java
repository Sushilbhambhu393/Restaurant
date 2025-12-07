package com.Restaurant.repository;

import com.Restaurant.model.Admin;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface IAdminRepo extends MongoRepository<Admin, String> {
    boolean existsByEmail(String email);
}