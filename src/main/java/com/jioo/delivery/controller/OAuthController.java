package com.jioo.delivery.controller;


import com.jioo.delivery.oauth.JwtConfig;
import com.jioo.delivery.oauth.JwtManager;
import com.jioo.delivery.oauth.service.OAuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.HashMap;

@RestController
@RequiredArgsConstructor
public class OAuthController {
    @Autowired
    private OAuthService oAuthService;
    private JwtManager jwtManager;



    @RequestMapping("/oauth2/code/kakao")
    public String kakaoLogin(@RequestParam String code) {
        String accessToken = oAuthService.getKakaoAccessToken(code);
        String jwtToken = oAuthService.getKakaoUserInfo(accessToken);
        System.out.println("token : " + jwtToken);
        return jwtToken;
    }


    @GetMapping("/api/jwt/info/{token}")
    public JwtManager.TokenInfo jwtInfo(@PathVariable String token) {
        JwtManager.TokenInfo tokenInfo = jwtManager.getTokenInfo(token);
        System.out.println("tokenInfo : " + tokenInfo);
        return tokenInfo;
    }
}