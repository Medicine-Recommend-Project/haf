package com.jsb.haf.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebMvcConfiguration implements WebMvcConfigurer {

    @Autowired
    LoggerInterceptor loggerInterceptor;

    @Override
    public void addInterceptors (InterceptorRegistry registry) {
        registry.addInterceptor(loggerInterceptor).excludePathPatterns("/assets/**");
    }

    /*
     *https://joshua-dev-story.blogspot.com/2020/01/react-spring-2.html
     * 개발 환경에서의 크로스 도메인 이슈를 해결하기 위한 코드로
     * 운영 환경에 배포할 경우에는 아래 함수를 주석 처리합니다.
     *
     * ※크로스 도메인 이슈: 브라우저에서 다른 도메인으로 URL 요청을 하는 경우 나타나는 보안문제
     */
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/api/**").allowCredentials(true).allowedOrigins("http://localhost:3000");
    }
}