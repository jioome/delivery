package com.jioo.delivery.service;

import com.jioo.delivery.domain.Restaurant;

public class RestaurantDto {
    private String name;
    private String address;
    private String callNumber;


    public RestaurantDto(String name, String address, String callNumber) {
        this.name = name;
        this.address = address;
        this.callNumber = callNumber;
    }

    public static RestaurantDto from(Restaurant restaurant){
        return new RestaurantDto(restaurant.getName(),restaurant.getAddress(),restaurant.getCallNumber());
    }
}
