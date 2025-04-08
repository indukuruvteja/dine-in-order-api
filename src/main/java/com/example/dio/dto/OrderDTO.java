package com.example.dio.dto;

import java.util.List;

public class OrderDTO {

    private Long id;
    private List<FoodItemDTO> foodItems;
    private double totalAmount;

    public OrderDTO() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<FoodItemDTO> getFoodItems() {
        return foodItems;
    }

    public void setFoodItems(List<FoodItemDTO> foodItems) {
        this.foodItems = foodItems;
    }

    public double getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(double totalAmount) {
        this.totalAmount = totalAmount;
    }
}
