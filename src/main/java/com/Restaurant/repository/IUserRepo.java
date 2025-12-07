package com.Restaurant.repository;

import com.Restaurant.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface IUserRepo extends MongoRepository<User, String> {
    User findByEmail(String email);
}