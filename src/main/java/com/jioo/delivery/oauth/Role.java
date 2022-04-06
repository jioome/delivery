package com.jioo.delivery.oauth;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor // 편리하게 의존성 주입
public enum Role {
    USER("ROLE_USER", "일반 사용자"),
    OWNER("ROLE_OWNER", "사장님"),
    GUEST("ROLE_GUEST", "손님"),
    ADMIN("ROLE_ADMIN","관리자");


    private final String key;
    private final String title;
}