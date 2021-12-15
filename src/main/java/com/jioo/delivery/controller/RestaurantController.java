package com.jioo.delivery.controller;

import com.jioo.delivery.service.RestaurantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class RestaurantController {
    @Autowired
    private RestaurantService restaurantService;

//    1.쿼리 파라미터로 전달받기
//    2. Request Body로 전달받기
//    3. Path Variable 로 전달받기

    @RequestMapping("/restaurant/{name}/{address}")
    public String createRestaurant(@PathVariable String name, @PathVariable String address){
        restaurantService.create(name,address);
        return "hello";
    }


    @GetMapping("/restaurant/{id}")
    public String readRestaurant(@PathVariable Long id){
        restaurantService.read(id);
        return "read";
    }

    @PostMapping("/restaurant/{id}")
    public String updateRestaurant(@PathVariable Long id){
        restaurantService.read(id);
        return "read";
    }

    @DeleteMapping("/restaurant/{id}")
    public String deleteRestaurant(@PathVariable Long id){
        restaurantService.delete(id);
        return "delete";
    }



}
