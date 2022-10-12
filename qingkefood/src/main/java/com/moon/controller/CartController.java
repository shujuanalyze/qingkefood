package com.moon.controller;

import com.moon.dto.CartDto;
import com.moon.entity.Fuser;
import com.moon.service.CartService;
import com.moon.service.impl.CartServiceDbImpl;
import com.moon.utils.UserUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

@RequestMapping("/cart")
@Controller
public class CartController {
    @Autowired
    @Qualifier("cartServiceRdImpl")
    private CartService cartService;

    @RequestMapping("/cartView")
    public String cartView() {
        return "cart";
    }

    //添加一件商品到购物车
    @RequestMapping("/addOneFoodToCart")
    @ResponseBody
    public String addOneFoodToCart(int foodId, String foodName, double price, HttpServletRequest req) {
        Fuser curruser = UserUtils.getCurrUser("token", Fuser.class, req);
        cartService.addOneFoodToCart(foodId, foodName, price, curruser.getId());
        return "success";
    }

    //查询购物车信息
    @RequestMapping("/selectCart")
    @ResponseBody
    public CartDto selectCart(HttpServletRequest req) {
        Fuser curruser = UserUtils.getCurrUser("token", Fuser.class, req);
        return cartService.selectByUserId(curruser.getId());
    }

    //更新购物车项
    @RequestMapping("/update")
    @ResponseBody
    public String update(int foodId, double price, int fcount, HttpServletRequest req) {
        //校验
        if (fcount > 100) {
            return "件数超出限制";
        }
        if (fcount < 1) {
            return "至少要购买1件";
        }
        //获取当前用户
        Fuser curruser = UserUtils.getCurrUser("token", Fuser.class, req);
        //更新
        double sumPrice = price * fcount;
        cartService.update(foodId, fcount, sumPrice, curruser.getId());
        return "success";
    }

    //删除购物车项
    @RequestMapping("/deleteByFoodId")
    @ResponseBody
    public String deleteByFoodId(int foodId, HttpServletRequest req) {
        //获取当前用户
        Fuser curruser = UserUtils.getCurrUser("token", Fuser.class, req);
        //删除
        cartService.deleteByFoodId(foodId, curruser.getId());
        return "success";
    }

    //
}
