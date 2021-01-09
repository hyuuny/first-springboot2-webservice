package com.setge.boot.springboot.web;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.RANDOM_PORT;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = RANDOM_PORT)
public class IndexControllerTest {

    @Autowired
    private TestRestTemplate restTemplate; // 빈으로 등록되어 있는 TestRestTemplates객체를 주입해준다.

    @Test
    public void 메인페이지_로딩() { // URL 호출 시 페이지의 내용이 제대로 호출되는지 테스트
        // when
        String body = this.restTemplate.getForObject("/", String.class);

        // then
        // index.mustache에 "첫 스프링부트로 시작하는 웹 서비스"가 포함되어 있는지 확인한다.
        assertThat(body).contains("첫 스프링부트로 시작하는 웹 서비스");
    }

}
