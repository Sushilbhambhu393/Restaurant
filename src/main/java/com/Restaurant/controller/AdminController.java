package com.Restaurant.controller;

import com.Restaurant.model.Admin;
import com.Restaurant.model.MenuItem;
import com.Restaurant.service.AdminService;
import com.Restaurant.service.FoodService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Slf4j
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

    @GetMapping("/exists")
    public ResponseEntity<Boolean> checkAdminExists(@RequestParam String email) {
        boolean exists = adminService.ifAdminExistOrNot(email);
        log.info( exists ? "Admin exists:"+email : "Admin does not exist:"+email);
        return ResponseEntity.ok(exists);
    }

    @PostMapping("/addFoodItem")
    public ResponseEntity<MenuItem> addFoodItem(@RequestBody MenuItem menuItem) {
        return ResponseEntity.ok(foodService.addFoodItem(menuItem));
    }
}