package com.jsb.haf.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

// Spring Security 中 (CSRF방지 Token생성)관련 이해하기 좋은 블로그  https://codevang.tistory.com/282

@Configuration  // 일단 메모리에 떠야 하니까 어노테이션 추가해줌
@EnableWebSecurity
//스프링 시큐리티 필터가 스프링 필터체인에 등록이 됨, 스프링 시큐리티 필터가 SecurityConfig 이것을 말한다.
//지금부터 등록할 필터가 기본 필터에 등록이 된다.
public class SecurityConfig extends WebSecurityConfigurerAdapter {
//  참고 : https://hhseong.tistory.com/173
//  참고2 : https://velog.io/@leyuri/Springboot-Security-2-%EC%8B%9C%ED%81%90%EB%A6%AC%ED%8B%B0-%EC%84%A4%EC%A0%95

    @Override
    public void configure(WebSecurity web) throws Exception {
//      WebSecurity filter 구현
//      * 해당 경로에는 security 가 모두 무시할 수 있도록 설정
//      * 기본 경로는 resources/static
        web.ignoring().antMatchers("/js/**", "/css/**", "/images/**", "/font/**", "/html/**");
        web.ignoring().antMatchers("./templates/**");
    }


    /*
     * 아래 코드 미리 설명
     * antMatchers().hasRole() → antMatchers()의 경로는 뒤의 hasRole()권한 사용자만 접근
     * antMatchers().permitAll() → antMatchers()경로에 권한없이 접근 가능
     * anyRequest().authenticated() → 모든 요청에 인증된
     */
    @Override
    protected void configure(HttpSecurity http) throws Exception {
//      HttpSecurity 구현
//      * http request 에 대한 보안 설정
//      * authorizeRequests() : request 에따라 접근 제어
        http.authorizeRequests()
///             ↓ admin 경로의 모든 경로는 ADMIN 권한 사용자만 접근 ↓
                .antMatchers("/api/**").hasRole("")
                .antMatchers("/admin/**").hasRole("ADMIN")
//              ↓ 모든 경로에 권한없이 접근 가능 ↓
                .antMatchers("/**").permitAll()
                .antMatchers("**").permitAll()
                .and()
//               form 로그인 기반으로 인증설정
                .formLogin()
                .loginPage("/login/form")
                .usernameParameter("userId")
                .passwordParameter("password")
                .loginProcessingUrl("/login/perform")
                .defaultSuccessUrl("/login/success")
                .failureUrl("/login/fail")
                .and()
                .logout()
                .logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
                .logoutSuccessUrl("/login/logout")
                .invalidateHttpSession(true)
                .and()
                .exceptionHandling().accessDeniedPage("/login/denied");
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

//    @Bean
//    public LoginService loginService() {
//        return new LoginService();
//    }


}
