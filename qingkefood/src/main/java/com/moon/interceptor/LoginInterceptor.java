package com.moon.interceptor;

import com.moon.utils.CookieUtils;
import com.moon.utils.JwtUtils;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Component
public class LoginInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String token = CookieUtils.getCookieVal("token", request);
        boolean flag = JwtUtils.verifyToken(token);
        if (!flag) {
            response.sendRedirect("/login");
        }
        return flag;
    }

    //
}
