package com.jioo.delivery.controller.request;

public class MenuRequest {
    private String name;
    private String description;
    private Integer price;
    private Long restaurantId;

    public MenuRequest(){

    }

    public MenuRequest(String name, String description, Integer price, Long restaurantId) {
        this.name = name;
        this.description = description;
        this.price = price;
        this.restaurantId = restaurantId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public Long getRestaurantId() {
        return restaurantId;
    }

    public void setRestaurantId(Long restaurantId) {
        this.restaurantId = restaurantId;
    }
}
