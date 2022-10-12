package com.moon.utils;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CookieUtils {
    //创建cookie
    public static void createCookie(String name, String val, HttpServletResponse resp) {
        Cookie cookie = new Cookie(name, val);
        cookie.setPath("/");
        resp.addCookie(cookie);
    }

    //根据cookie名获取cookie值
    public static String getCookieVal(String name, HttpServletRequest req) {
        Cookie[] cookies = req.getCookies();
        if (cookies != null) {
            for (Cookie ck : cookies) {
                if (ck.getName().equals(name)) {
                    return ck.getValue();
                }
            }
        }
        return null;
    }

    //
}
