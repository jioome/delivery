package com.jioo.delivery.controller;

import com.jioo.delivery.controller.request.RestaurantRequest;
import com.jioo.delivery.controller.request.UserRequest;
import com.jioo.delivery.controller.response.RestaurantResponse;
import com.jioo.delivery.domain.Restaurant;
import com.jioo.delivery.domain.User;
import com.jioo.delivery.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/user")
    public User createUser(@RequestBody UserRequest userRequest) {
        return userService.create(userRequest);
    }

    @GetMapping("/user/{id}")
    public User readUser(@PathVariable Long id) {
        return userService.read(id);
    }

//    @PutMapping("/user/{id}")
//    public User updateUser(@PathVariable Long id, @RequestBody UserRequest userRequest) throws Exception {
//
//        final User user = userService.update(id, UserRequest);
//        return new User(user);
//    }

//    @DeleteMapping("/user/{id}")
//    public void deleteUser(@PathVariable Long id) {
//        userService.delete(id);
//
//    }



}
