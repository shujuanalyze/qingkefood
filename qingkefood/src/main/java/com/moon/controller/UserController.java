package com.moon.controller;

import com.moon.entity.Fuser;
import com.moon.service.UserService;
import com.moon.utils.CookieUtils;
import com.moon.utils.JwtUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@RequestMapping("/user")
@Controller
public class UserController {
    @Autowired
    private UserService userService;

    @RequestMapping("/login")
    public String login(String account, String password, HttpSession sess, HttpServletResponse resp) {
        Fuser user = userService.selectByAccountAndPassword(account, password);
        if (user == null) {
            return "redirect:/login";
        }
        //success
        user.setPassword("");
        String token = JwtUtils.getToken(user, 2 * 3600 * 1000);
        //将token存入浏览器cookie
        CookieUtils.createCookie("token", token, resp);
        return "redirect:/";
    }

    //
}
