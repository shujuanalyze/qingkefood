package com.moon.utils;

import javax.servlet.http.HttpServletRequest;

public class UserUtils {
    //根据令牌名获取用户对象
    public static <T> T getCurrUser(String tokenName, Class<T> clazz, HttpServletRequest req) {
        String token = CookieUtils.getCookieVal(tokenName, req);
        T user = JwtUtils.getUser(token, clazz);
        return user;
    }

    //
}
