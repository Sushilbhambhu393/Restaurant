package com.Restaurant.model;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "menu")
@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class Menu {

    private String id;
    private String itemName;
    private String description;
    private double price;
    private String category;

//    public String getId() {
//        return id;
//    }
//    public void setId(String id) {
//        this.id = id;
//    }
//    public String getItemName() {
//        return itemName;
//    }
//    public void setItemName(String itemName) {
//        this.itemName = itemName;
//    }
//    public String getDescription() {
//        return description;
//    }
//    public void setDescription(String description) {
//        this.description = description;
//    }
//    public double getPrice() {
//        return price;
//    }
//    public void setPrice(double price) {
//        this.price = price;
//    }
//    public String getCategory() {
//        return category;
//    }
//    public void setCategory(String category) {
//        this.category = category;
//    }
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

