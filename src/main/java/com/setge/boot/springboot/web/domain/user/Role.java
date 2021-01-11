package com.setge.boot.springboot.web.domain.user;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum Role { // 사용자의 권한을 관리할 Enum클래시

    // 스프링 시큐리티에서는 권한 코드에 항상 ROLE_이 앞에 있어야만 한다.
    // 그래서 GUEST와 USER앞에 ROLE_을 지정하였다.
    GUEST("ROLE_GUEST", "손님"),
    USER("ROLE_USER", "일반 사용자");

    private final String key;
    private final String title;
}
