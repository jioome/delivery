package com.jioo.delivery.controller;

import com.jioo.delivery.controller.request.RestaurantRequest;
import com.jioo.delivery.controller.request.UserRequest;
import com.jioo.delivery.controller.response.RestaurantResponse;
import com.jioo.delivery.domain.Restaurant;
import com.jioo.delivery.domain.User;
import com.jioo.delivery.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/user")
    public User createRestaurant(@RequestBody UserRequest userRequest) {
        return userService.create(userRequest);
    }

    @GetMapping("/user/{id}")
    public User readRestaurant(@PathVariable Long id) {
        return userService.read(id);
    }
}
