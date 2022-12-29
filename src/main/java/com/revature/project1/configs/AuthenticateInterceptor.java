package com.revature.project1.configs;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.MDC;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

@Component
public class AuthenticateInterceptor implements HandlerInterceptor {

    private Logger log = LoggerFactory.getLogger(getClass());

    @Override
    public void afterCompletion(HttpServletRequest request,
            HttpServletResponse response,
            Object handler,
            @Nullable Exception ex)
            throws Exception {
        System.out.println("afterCompletion");
        MDC.clear();
    }

    @Override
    public void postHandle(HttpServletRequest request,
            HttpServletResponse response,
            Object handler,
            @Nullable ModelAndView modelAndView)
            throws Exception {
        System.out.println("postHandle");
        log.info("Response");
    }

    @Override
    public boolean preHandle(HttpServletRequest request,
            HttpServletResponse response,
            Object handler)
            throws Exception {
        System.out.println("preHandle");
        MDC.put("METHOD", request.getMethod());
        MDC.put("URI", request.getRequestURI());
        log.info("Request");
        return true;
    }

}
