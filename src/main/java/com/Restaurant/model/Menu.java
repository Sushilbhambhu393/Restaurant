package com.Restaurant.model;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "menu")
public class Menu {

    private String id;
    private String itemName;
    private String description;
    private double price;
    private String category;

    @Override
    public String toString() {
        return "Menu{" +
                "id='" + id + '\'' +
                ", itemName='" + itemName + '\'' +
                ", description='" + description + '\'' +
                ", price=" + price +
                ", category='" + category + '\'' +
                '}';
    }

}

