package com.jioo.delivery.oauth;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.JsonElement;
import com.jioo.delivery.oauth.property.KakaoOAuthProviderProperties;
import com.jioo.delivery.oauth.property.KakaoOAuthRegistrationProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

@Service
public class OAuthService {

    @Autowired
    private KakaoOAuthRegistrationProperties kakaoOAuthRegistrationProperties;

    @Autowired
    private KakaoOAuthProviderProperties kakaoOAuthProviderProperties;

    @Autowired
    private RestTemplate restTemplate;

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

    public HashMap<String, Object> getKakaoUserInfo(String access_Token) {

        //    요청하는 클라이언트마다 가진 정보가 다를 수 있기에 HashMap타입으로 선언
        HashMap<String, Object> userInfo = new HashMap<>();
        String reqURL = "https://kapi.kakao.com/v2/user/me";
        try {
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

            int id = element.getAsJsonObject().get("id").getAsInt();
            String nickname = properties.getAsJsonObject().get("nickname").getAsString();
            String email = kakao_account.getAsJsonObject().get("email").getAsString();


            userInfo.put("Id", id);
            userInfo.put("nickname", nickname);
            userInfo.put("email", email);

        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        return userInfo;
    }

}