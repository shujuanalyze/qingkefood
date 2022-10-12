package com.moon.config;

import com.moon.interceptor.LoginInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.ArrayList;
import java.util.List;

@Configuration
public class InterceptorConfig implements WebMvcConfigurer {
    @Autowired
    private LoginInterceptor loginInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        List<String> excludelist = new ArrayList<String>();
        excludelist.add("/**/*login*/**");
        excludelist.add("/**/*register*/**");
        excludelist.add("/**/*success*/**");
        excludelist.add("/**/*error*/**");
        excludelist.add("/redisTest/call");
        registry.addInterceptor(loginInterceptor).addPathPatterns("/**").excludePathPatterns(excludelist);
    }

    //
}
