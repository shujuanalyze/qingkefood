package com.moon.controller;

import com.moon.entity.Provider;
import com.moon.service.ProviderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@RequestMapping("/provider")
@Controller
public class ProviderController {
    @Autowired
    private ProviderService providerService;

    @RequestMapping("/selectByTypeId")
    @ResponseBody
    public List<Provider> selectByTypeId(int typeId) {
        return providerService.selectByTypeId(typeId);
    }

    //访问商家详情界面
    @RequestMapping("/providerView")
    public String providerView(int providerId, Model model) {
        model.addAttribute("providerId", providerId);
        return "provider";
    }

    //根据id获取商家详情
    @RequestMapping("/selectById")
    @ResponseBody
    public Provider selectById(int providerId) {
        return providerService.selectById(providerId);
    }

    //
}
