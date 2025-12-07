package com.Restaurant.service;

import com.Restaurant.model.User;
import com.Restaurant.repository.IUserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private IUserRepo userRepo;

    public User registerUser(User user) {
        return userRepo.save(user);
    }

    public boolean authenticateUser(String email, String password) {
        User user = userRepo.findByEmail(email);
        return user != null && user.getPassword().equals(password);
    }

    public User findFirstByUserEmail(String email) {
        return userRepo.findByEmail(email);
    }
}