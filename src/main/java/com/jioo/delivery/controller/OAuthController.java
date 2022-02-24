package com.jioo.delivery.controller;


import com.jioo.delivery.oauth.KakaoApiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.HashMap;

@RestController
public class OAuthController {
    @Autowired
    private KakaoApiService kakao;

    @RequestMapping(value = "/login/getKakaoAuthUrl")
    public @ResponseBody String getKakaoAuthUrl(
            HttpServletRequest request) throws Exception {
        String reqUrl =
                "https://kauth.kakao.com/oauth/authorize"
                        + "?client_id=3aec12f8d63a56d464f93137911e7bb6"
                        + "&redirect_uri=http://localhost:8080/oauth2/code/kakao"
                        + "&response_type=code";

        return reqUrl;
    }


    @RequestMapping("/oauth2/code/kakao")
    public String kakaoLogin(@RequestParam String code, HttpSession session){
        String access_Token = kakao.getKakaoAccessToken(code);
//        System.out.println("###access_Token#### " + access_Token);
        HashMap<String, Object> userInfo = kakao.getUserInfo(access_Token);
        System.out.println("login Controller : " + userInfo);

        //    클라이언트의 이메일이 존재할 때 세션에 해당 이메일과 토큰 등록
        if (userInfo.get("email") != null) {
            session.setAttribute("userId", userInfo.get("email"));
            session.setAttribute("access_Token", access_Token);
        }
        return "index";
    }
}