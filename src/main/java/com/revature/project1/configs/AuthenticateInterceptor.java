package com.revature.project1.configs;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.MDC;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.revature.project1.exceptions.NotLoggedInException;

@Component
public class AuthenticateInterceptor implements HandlerInterceptor {

    @Override
    public void afterCompletion(HttpServletRequest request,
            HttpServletResponse response,
            Object handler,
            @Nullable Exception ex)
            throws Exception {

        MDC.clear();
    }

    @Override
    public boolean preHandle(HttpServletRequest request,
            HttpServletResponse response,
            Object handler)
            throws Exception {

        MDC.put("METHOD", request.getMethod());
        MDC.put("URI", request.getRequestURI());
        HttpSession session = request.getSession();

        if (session.getAttribute("user") == null) {
            throw new NotLoggedInException();
        }

        return true;
    }

}
