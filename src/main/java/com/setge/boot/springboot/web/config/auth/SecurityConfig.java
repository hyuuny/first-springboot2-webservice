package com.setge.boot.springboot.web.config.auth;

import com.setge.boot.springboot.web.domain.user.Role;
import lombok.RequiredArgsConstructor;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@RequiredArgsConstructor
@EnableWebSecurity // Spring Security 설정들을 활성화 시킨다.
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    private final CustomOAuth2UserService customOAuth2UserService;

    /*
    * csrf().disable().headers().frameOptions().disable() : h2-console 화면을 사용하기 위해 해당 옵션들을 disable 한다.
    * authorizeRequests() : URL별 권한 관리를 설정하는 옵션의 시작점
    * antMatchers() : 권한 관리 대상을 지정하는 옵션("/", "/css/**" 등은 permitAll() 전체열람, "api/v1/**"주소는 USER권한 필요)
    * andRequest() : 설정된 값들 이외 나머지 URL을 나타낸다. 여기선 authenticated()를 추가하여 나머지 URL은 인증된 사용자만이 접근 허용된다.
    * logout().logoutSuccessUrl("/") : 로그아웃 기능에 대한 설정의 진입점, 로그아웃에 성공하면 "/" 주소로 이동한다.
    * oauth2Login() : OAuth2 로그인 기능에 대한 여러 설정의 진입점이다.
    * userInfoEndporint() : OAuth2 로그인 성공 이후 사용자 정보를 가져올 때의 설정들을 담당한다.
    * userService : 소셜 로그인 성공 시 후속 조치를 진행할 UserService 인터페이스의 구현체를 등록한다.
    *
    * */
    @Override
    protected void configure(HttpSecurity http) throws Exception{ // protected : 다른 패키지의 자손클래스에서 접근 가능
        http.csrf().disable().headers().frameOptions().disable().and()
                .authorizeRequests().antMatchers("/", "/css**", "/images/**", "/js/**"
                ,"/h2-console/**").permitAll().antMatchers("/api/v1/**").hasRole(Role.USER.name())
                .anyRequest().authenticated().and().logout().logoutSuccessUrl("/")
                .and().oauth2Login().userInfoEndpoint().userService(customOAuth2UserService);
    }

}

