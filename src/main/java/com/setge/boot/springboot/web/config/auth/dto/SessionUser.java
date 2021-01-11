package com.setge.boot.springboot.web.config.auth.dto;

import com.setge.boot.springboot.web.domain.user.User;
import lombok.Getter;

@Getter
public class SessionUser { // 인증된 사용자의 정보만 필요한 SessionUser클래스

    private String name;
    private String email;
    private String picture;

    public SessionUser(User user) {
        this.name = user.getName();
        this.email = user.getEmail();
        this.picture = user.getPicture();
    }
}
