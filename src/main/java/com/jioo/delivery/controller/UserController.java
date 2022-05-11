package com.jioo.delivery.controller;

import com.jioo.delivery.oauth.User;
import com.jioo.delivery.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/user/me")
    public User userMe(@AuthenticationPrincipal UserDetails userDetails) {
        System.out.println(userService.findByEmail(userDetails.getUsername()));
//      // 반환용 객체 사용
        return userService.findByEmail(userDetails.getUsername()).orElseThrow(NullPointerException::new);
    }

    @GetMapping("/user/{id}")
    public User readUser(@PathVariable Long id) {
        return userService.read(id);
    }
}