package com.revature.project1.configs;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.MDC;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

@Component
public class LoggingInterceptor implements HandlerInterceptor {

    @Override
    public void afterCompletion(HttpServletRequest request,
            HttpServletResponse response,
            Object handler,
            @Nullable Exception ex)
            throws Exception {

        Logger log = LoggerFactory.getLogger(getClass());
        log.info(System.getenv("HOSTNAME") + "SessionID: " + request.getSession().getId().toString());
        MDC.clear();
    }

    @Override
    public boolean preHandle(HttpServletRequest request,
            HttpServletResponse response,
            Object handler)
            throws Exception {

        MDC.put("METHOD", request.getMethod());
        MDC.put("URI", request.getRequestURI());
        return true;
    }

}
