package com.moon.controller;

import com.moon.dao.ProviderMapper;
import com.moon.entity.Provider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@RequestMapping("/demo")
@Controller
public class DemoController {
    @Autowired
    private ProviderMapper providerMapper;

    @RequestMapping("/query")
    @ResponseBody
    public List<Provider> query() {
        return providerMapper.selectByTypeId(1);
    }

    //
}
