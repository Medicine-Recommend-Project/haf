package com.jsb.haf.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.http.CacheControl;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.concurrent.TimeUnit;


@Configuration
public class MvcConfiguration {
    /*
     * 참고2 : https://bottom-to-top.tistory.com/39?category=807633
     * / 를 시작으로 하는 모든 요청을 다룬다는 것을 의미합니다.
     * 1번에 해당하는 요청을 처리할 자원을 찾을 위치를 나타냅니다.
     * 요청에 대한 Cache를 10분으로 설정한 것입니다. 이 부분은 신경쓰지 않으셔도 좋습니다.
     * */
    @Profile("prod")
    @Configuration
    public static class ProdMvcConfiguration implements WebMvcConfigurer {

        @Override
        public void addResourceHandlers(final ResourceHandlerRegistry registry) {
            registry.addResourceHandler("/**")
                    .addResourceLocations("classpath:/templates/", "classpath:/static/")
                    .setCacheControl(CacheControl.maxAge(10, TimeUnit.MINUTES));
        }
    }

    @Profile("local")
    @Configuration
    public static class LocalMvcConfiguration implements WebMvcConfigurer {

        @Override
        public void addResourceHandlers(final ResourceHandlerRegistry registry) {
            registry.addResourceHandler("/**")
                    .addResourceLocations("file:src/main/resources/templates/", "file:src/main/resources/static/");
        }
    }

    @Configuration
    public class MvcConfigurationaddInterceptors implements WebMvcConfigurer {

        @Override
        public void addInterceptors(InterceptorRegistry registry) {
            registry.addInterceptor(new LoggerInterceptor())
                    .excludePathPatterns("/css/**", "/fonts/**", "/plugin/**", "/scripts/**");
        }

    }

}
