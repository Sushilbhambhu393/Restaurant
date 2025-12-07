package com.Restaurant.model;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class OrderItem {
    private String foodItemId;
    private int quantity;
    private double price; // Price per unit
}