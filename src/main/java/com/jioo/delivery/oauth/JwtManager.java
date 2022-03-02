package com.jioo.delivery.oauth;

import java.nio.charset.StandardCharsets;
import java.security.Key;
import java.util.Date;
import java.util.Set;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import lombok.Getter;

import java.io.UnsupportedEncodingException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class JwtManager {
    private String secretKey;
    private long TOKEN_VALIDATiON_SECOND = 60;

    public JwtManager(String secretKey, long TOKEN_VALIDATiON_SECOND) {
        this.secretKey = secretKey;
        this.TOKEN_VALIDATiON_SECOND = TOKEN_VALIDATiON_SECOND;
    }

    // secretKey 로드
    private Key getSigninKey() {
        byte[] keyBytes = secretKey.getBytes(StandardCharsets.UTF_8);
        return Keys.hmacShaKeyFor(keyBytes);
    }

    // 토큰 생성
    public String generateToken(String email,String name,String picture) {
        Claims claims = Jwts.claims();
        claims.put("email", email);
        claims.put("username", name);
        claims.put("picture", picture);

        return Jwts.builder()
                .setClaims(claims)
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + (TOKEN_VALIDATiON_SECOND * 1000)))
                .signWith(getSigninKey(), SignatureAlgorithm.HS256)
                .compact();
    }

    // 토큰 정보 리턴
    public TokenInfo getTokenInfo(String token) {
        Claims body = getClaims(token);
        Set<String> keySet = body.keySet();
        for (String s : keySet) {
            System.out.println("s = " + s);
        }

        String email = body.get("email", String.class);
        String username = body.get("username", String.class);
        String picture = body.get("picture", String.class);
        Date issuedAt = body.getIssuedAt();
        Date expiration = body.getExpiration();

        System.out.println("Token Info -----------");
        System.out.println("email : " + email);
        System.out.println("username : " + username);
        System.out.println("picture : " + picture);
        System.out.println("issuedAt : " + issuedAt);
        System.out.println("expiration : " + expiration);

        return new TokenInfo(email,username,picture, issuedAt, expiration);
    }


    // 토큰정보 해석
    private Claims getClaims(String token) {
        Claims body = Jwts.parserBuilder()
                .setSigningKey(getSigninKey())
                .build()
                .parseClaimsJws(token)
                .getBody();
        return body;
    }


    @Getter
    public class TokenInfo {
        private String email;
        private String username;
        private String picture;
        private Date issuedAt;
        private Date expire;

        public TokenInfo(String email,String username,String picture,Date issuedAt, Date expire) {
            this.email = email;
            this.username = username;
            this.picture = picture;
            this.issuedAt = issuedAt;
            this.expire = expire;
        }
    }
}