package com.jioo.delivery.controller;


import com.jioo.delivery.oauth.OAuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;

@RestController
public class OAuthController {
    @Autowired
    private OAuthService oAuthService;

    @RequestMapping("/oauth2/code/kakao")
    public String kakaoLogin(@RequestParam String code) {
        String accessToken = oAuthService.getKakaoAccessToken(code);
        HashMap<String, Object> userInfo = oAuthService.getKakaoUserInfo(accessToken);

        return "index";
    }
}