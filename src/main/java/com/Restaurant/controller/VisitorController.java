package com.Restaurant.controller;

import com.Restaurant.model.MenuItem;
import com.Restaurant.service.FoodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/visitor")
public class VisitorController {

    @Autowired
    private FoodService foodService;

    @GetMapping("/getAllFoodItems")
    public ResponseEntity<List<MenuItem>> getAllFoodItems() {
        return ResponseEntity.ok(foodService.getAllFoodItems());
    }
}