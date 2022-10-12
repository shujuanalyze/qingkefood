package com.moon.controller;

import com.moon.dto.CartDto;
import com.moon.entity.Fuser;
import com.moon.service.CartService;
import com.moon.service.OrderService;
import com.moon.utils.UserUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

@RequestMapping("/order")
@Controller
public class OrderController {
    @Autowired
    private OrderService orderService;
    @Autowired
    @Qualifier("cartServiceRdImpl")
    private CartService cartService;

    @RequestMapping("/orderView")
    public String orderView() {
        return "order";
    }

    //新增订单
    @RequestMapping("/insert")
    @ResponseBody
    public String insert(String fulladdr, HttpServletRequest req) {
        //当前登录用户
        Fuser currUser = UserUtils.getCurrUser("token", Fuser.class, req);
        //验证购物车是否为空
        CartDto cartDto = cartService.selectByUserId(currUser.getId());
        if (cartDto == null || cartDto.getItems() == null || cartDto.getItems().size() < 1) {
            return "购物车为空,不可下单.";
        }
        //执行下单流程
        try {
            orderService.insertOrderAndDetails(fulladdr, currUser.getId());
            return "success";
        } catch (Exception e) {
            e.printStackTrace();
            return "操作失败,请稍后重试.";
        }
    }

    //
}
