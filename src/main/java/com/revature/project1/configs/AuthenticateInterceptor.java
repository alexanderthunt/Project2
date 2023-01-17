package com.revature.project1.configs;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import com.revature.project1.exceptions.NotLoggedInException;

@Component
public class AuthenticateInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request,
            HttpServletResponse response,
            Object handler)
            throws Exception {

        if (request.getSession().getAttribute("user") == null) {
            throw new NotLoggedInException();
        }

        return true;
    }

}
