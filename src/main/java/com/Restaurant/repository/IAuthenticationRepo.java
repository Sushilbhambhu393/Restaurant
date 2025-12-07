package com.Restaurant.repository;

import com.Restaurant.model.AuthenticationToken;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface IAuthenticationRepo extends MongoRepository<AuthenticationToken, String> {
    AuthenticationToken findByToken(String token);
}