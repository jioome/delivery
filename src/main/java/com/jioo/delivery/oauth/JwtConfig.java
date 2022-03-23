package com.jioo.delivery.oauth;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class JwtConfig {
    private static String jwtSecret = "dGVzdC1qd3Qtc2ewFtcGxlLXNwcmluZ2Jvb3Q=";


    // 유효시간을 86400 초로 계산
    private long tokenValidityInSeconds = 86400;

    @Bean
    public AuthTokenProvider jwtManager() {
        return new AuthTokenProvider(jwtSecret);
    }
    public static String getJwtSecret() {
        return jwtSecret;
    }


}
