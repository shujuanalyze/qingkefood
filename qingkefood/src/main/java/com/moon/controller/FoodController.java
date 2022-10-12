package com.moon.controller;

import com.moon.entity.Food;
import com.moon.service.FoodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@RequestMapping("/food")
@Controller
public class FoodController {
    @Autowired
    private FoodService foodService;

    //根据商家id获得食品列表
    @RequestMapping("/selectByProviderId")
    @ResponseBody
    public List<Food> selectByProviderId(int providerId) {
        return foodService.selectByProviderId(providerId);
    }

    //
}
