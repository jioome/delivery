package com.jioo.delivery.service;

import com.jioo.delivery.controller.request.RestaurantRequest;
import org.springframework.stereotype.Service;

//비즈니스 로직을 수행하는 Class라는 것을 나타내는 용도
@Service
public class RestaurantService {
    public void create(RestaurantRequest restaurantParameter){
        System.out.println(restaurantParameter.getName());
        System.out.println(restaurantParameter.getAddress());
    }
    public void read(Long id){
        System.out.println(id);
    }
    public void update(Long id ,String name,String address){
        System.out.println(id);
        System.out.println(name);
        System.out.println(address);
    }
    public void delete(Long id){
        System.out.println(id);
    }
}
