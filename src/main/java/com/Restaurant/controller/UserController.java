package com.Restaurant.controller;

import com.Restaurant.model.MenuItem;
import com.Restaurant.model.Order;
import com.Restaurant.model.User;
import com.Restaurant.service.FoodService;
import com.Restaurant.service.OrderService;
import com.Restaurant.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private FoodService foodService;

    @Autowired
    private OrderService orderService;

    @PostMapping("/signUp")
    public ResponseEntity<User> signUpUser(@RequestBody User user) {
        return ResponseEntity.ok(userService.registerUser(user));
    }

    @PostMapping("/signIn")
    public ResponseEntity<String> signInUser(@RequestParam String email, @RequestParam String password) {
        boolean isAuthenticated = userService.authenticateUser(email, password);
        if (isAuthenticated) {
            return ResponseEntity.ok("User signed in successfully.");
        } else {
            return ResponseEntity.status(401).body("Invalid credentials.");
        }
    }

    @PostMapping("/addOrder")
    public ResponseEntity<Order> addOrder(@RequestBody Order order) {
        return ResponseEntity.ok(orderService.placeOrder(order));
    }

    @GetMapping("/getAllFoodItems")
    public ResponseEntity<List<MenuItem>> getAllFoodItems() {
        return ResponseEntity.ok(foodService.getAllFoodItems());
    }
}