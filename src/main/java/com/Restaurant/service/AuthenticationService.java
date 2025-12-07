package com.Restaurant.service;

import com.Restaurant.model.AuthenticationToken;
import com.Restaurant.repository.IAuthenticationRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthenticationService {

    @Autowired
    private IAuthenticationRepo authenticationRepo;

    public void saveAuthToken(AuthenticationToken token) {
        authenticationRepo.save(token);
    }

    public boolean authenticate(String token) {
        AuthenticationToken authToken = authenticationRepo.findByToken(token);
        return authToken != null && !authToken.isExpired();
    }
}