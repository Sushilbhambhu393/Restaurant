package com.Restaurant.service;

import com.Restaurant.model.MenuItem;
import com.Restaurant.repository.IFoodRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FoodService {

    @Autowired
    private IFoodRepo foodRepo;

    public MenuItem addFoodItem(MenuItem menuItem) {
        return foodRepo.save(menuItem);
    }

    public boolean isFoodInTheMenu(String name) {
        return foodRepo.existsByName(name);
    }

    public List<MenuItem> getAllFoodItems() {
        return foodRepo.findAll();
    }
}