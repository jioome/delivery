package com.jioo.delivery.controller;

import com.jioo.delivery.oauth.User;
import com.jioo.delivery.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private UserService userService;

    @GetMapping("/user/{id}")
    public User readUser(@PathVariable Long id) {
        return userService.read(id);
    }
}