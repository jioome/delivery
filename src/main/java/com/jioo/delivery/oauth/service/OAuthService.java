package com.jioo.delivery.oauth.service;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.JsonElement;
import com.jioo.delivery.oauth.*;
import com.jioo.delivery.oauth.config.JwtConfig;
import com.jioo.delivery.oauth.property.KakaoOAuthProviderProperties;
import com.jioo.delivery.oauth.property.KakaoOAuthRegistrationProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Date;
import java.util.HashMap;

import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

@Service
public class OAuthService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private KakaoOAuthRegistrationProperties kakaoOAuthRegistrationProperties;

    @Autowired
    private KakaoOAuthProviderProperties kakaoOAuthProviderProperties;

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private AuthTokenProvider authTokenProvider;



    public String getKakaoAccessToken(String code) {
        final String tokenUri = UriComponentsBuilder.fromHttpUrl(kakaoOAuthProviderProperties.getTokenUri())
                .queryParam("grant_type", "authorization_code")
                .queryParam("client_id", kakaoOAuthRegistrationProperties.getClientId())
                .queryParam("redirect_uri", kakaoOAuthRegistrationProperties.getRedirectUri())
                .queryParam("code", code)
                .build()
                .toString();

        final OAuthToken oAuthToken = restTemplate.exchange(tokenUri, HttpMethod.POST, null, OAuthToken.class).getBody();
        if (oAuthToken == null) return "";

        return oAuthToken.getAccessToken();
    }
    public boolean checkEmailDuplicate(String email){
        return userRepository.existsByEmail(email);
    }
    public AuthToken getKakaoUserInfo(String access_Token) throws IOException {

        //    요청하는 클라이언트마다 가진 정보가 다를 수 있기에 HashMap타입으로 선언
        HashMap<String, Object> userInfo = new HashMap<>();
        String reqURL = "https://kapi.kakao.com/v2/user/me";

        URL url = new URL(reqURL);
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("POST");

        //    요청에 필요한 Header에 포함될 내용
        conn.setRequestProperty("Authorization", "Bearer " + access_Token);

        int responseCode = conn.getResponseCode();
        System.out.println("responseCode : " + responseCode);

        BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream()));

        String line = "";
        String result = "";

        while ((line = br.readLine()) != null) {
            result += line;
        }
        System.out.println("response body : " + result);

        JsonParser parser = new JsonParser();
        JsonElement element = parser.parse(result);

        JsonObject properties = element.getAsJsonObject().get("properties").getAsJsonObject();
        JsonObject kakao_account = element.getAsJsonObject().get("kakao_account").getAsJsonObject();

        int userId = element.getAsJsonObject().get("id").getAsInt();
        String name = properties.getAsJsonObject().get("nickname").getAsString();
        String email = kakao_account.getAsJsonObject().get("email").getAsString();
        String picture = properties.getAsJsonObject().get("profile_image").getAsString();

        String username = email;
        String password = userId + access_Token;
        //  DB 저장
        User user = new User();
        user.setUserId(userId);
        user.setEmail(email);
        user.setName(name);
        user.setPicture(picture);


        // 중복체크
        if(!checkEmailDuplicate(email)){
            userRepository.save(user);
        }
        Long expiredTime = 1000 * 60L * 60L * 2L; // 토큰 유효 시간 (2시간)

        Date ext = new Date(); // 토큰 만료 시간
        ext.setTime(ext.getTime() + expiredTime);

        AuthToken authToken = new AuthTokenProvider(JwtConfig.getJwtSecret()).createToken(email,ext);

        return authToken;



    }


}