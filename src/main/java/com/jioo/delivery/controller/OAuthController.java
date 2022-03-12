package com.jioo.delivery.controller;


import com.jioo.delivery.oauth.AuthToken;
import com.jioo.delivery.oauth.AuthTokenProvider;
import com.jioo.delivery.oauth.service.OAuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@RestController
@RequiredArgsConstructor
public class OAuthController {
    @Autowired
    private OAuthService oAuthService;
    private AuthTokenProvider jwtManager;



    @RequestMapping("/oauth2/code/kakao")
    public AuthToken kakaoLogin(@RequestParam String code) throws IOException {
        String accessToken = oAuthService.getKakaoAccessToken(code);
        AuthToken jwtToken = oAuthService.getKakaoUserInfo(accessToken);
        System.out.println("token : " + jwtToken);
        return jwtToken;
    }

}