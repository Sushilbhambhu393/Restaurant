package com.Restaurant.model;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "orders")
public class Order {
    @Id
    private String id;
    private List<OrderItem> items;
    private String userId;
    private double totalPrice;
    private String status;


    public void calculateTotalPrice() {
        this.totalPrice = items.stream()
                .mapToDouble(item -> item.getPrice() * item.getQuantity())
                .sum();
    }
}