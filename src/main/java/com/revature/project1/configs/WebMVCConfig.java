package com.revature.project1.configs;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebMVCConfig implements WebMvcConfigurer {

    @Autowired
    private AuthenticateInterceptor authInterceptor;

    @Autowired
    private LoggingInterceptor logInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {

        registry.addInterceptor(authInterceptor).addPathPatterns("/api/**");
        registry.addInterceptor(logInterceptor).addPathPatterns("/**").order(Ordered.HIGHEST_PRECEDENCE);
    }

}
