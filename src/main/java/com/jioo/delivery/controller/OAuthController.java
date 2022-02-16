package com.jioo.delivery.controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OAuthController {

    @GetMapping("/oauth2/code/kakao")
    public String getCodeFromKakao(@RequestParam String code) {
        return code;
    }
}
