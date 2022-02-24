package com.jioo.delivery.oauth.property;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Data
@Configuration
@ConfigurationProperties(prefix = "spring.security.oauth2.client.provider.kakao")
@PropertySource(value = "classpath:application.yaml", factory = YamlPropertySourceFactory.class)
public class KakaoOAuthProviderProperties {

    private String tokenUri;

    private String userInfoUri;

    private String authorizationUri;
}
