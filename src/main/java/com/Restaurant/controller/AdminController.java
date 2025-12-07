package com.Restaurant.controller;

import com.Restaurant.model.Admin;
import com.Restaurant.model.MenuItem;
import com.Restaurant.service.AdminService;
import com.Restaurant.service.FoodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private AdminService adminService;

    @Autowired
    private FoodService foodService;

    @PostMapping("/add")
    public ResponseEntity<Admin> addAdmin(@RequestBody Admin admin) {
        return ResponseEntity.ok(adminService.addAdmin(admin));
    }

    @GetMapping("/exists/{email}")
    public ResponseEntity<Boolean> checkAdminExists(@PathVariable String email) {
        return ResponseEntity.ok(adminService.ifAdminExistOrNot(email));
    }

    @PostMapping("/addFoodItem")
    public ResponseEntity<MenuItem> addFoodItem(@RequestBody MenuItem menuItem) {
        return ResponseEntity.ok(foodService.addFoodItem(menuItem));
    }
}