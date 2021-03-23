package com.jsb.haf.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Enumeration;

// 참고 : https://linked2ev.github.io/gitlog/2019/09/15/springboot-mvc-12-%EC%8A%A4%ED%94%84%EB%A7%81%EB%B6%80%ED%8A%B8-MVC-Interceptor-%EC%84%A4%EC%A0%95/

@Slf4j
@Component
public class LoggerInterceptor extends HandlerInterceptorAdapter {
    // 재고관리 팀프로젝트 시 사용한 start end
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        if (log.isDebugEnabled()) {
            log.info("======================================          START         ======================================");
            log.info(" Request URI \t:  " + request.getRequestURI());
        }
        return super.preHandle(request, response, handler);
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

        if (log.isDebugEnabled()) {
            log.info("======================================           END          ======================================\n");
        }
    }

    /*
    //controller로 보내기 전 이벤트 작동(false - controller로 요청을 안함)
    
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        log.debug("============================== START ==============================");
        log.info(" Class       \t:  " + handler.getClass());
        log.info(" Request URI \t:  " + request.getRequestURI());
        log.info(" Servlet URI \t:  " + request.getServletPath());

        Enumeration<String> paramNames = request.getParameterNames();

        while (paramNames.hasMoreElements()) {
            String key = (String) paramNames.nextElement();
            String value = request.getParameter(key);
            log.info("# RequestParameter: " + key + "=" + value + "");
        }
        log.info("==================================================================== ");

        return super.preHandle(request, response, handler);
    }

    //controller 처리 이후 이벤트 작동
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        //log.info("================================ END ================================");
    }

    //view 처리 이후 이벤트 작동
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        log.info("================================ END ================================");
    }
     */
}
