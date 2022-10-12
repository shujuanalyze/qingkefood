package com.moon.controller;

import com.moon.entity.China;
import com.moon.service.ChinaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@RequestMapping("/china")
@Controller
public class ChinaController {
    @Autowired
    private ChinaService chinaService;

    @RequestMapping("/selectProv")
    @ResponseBody
    public List<China> selectProv() {
        return chinaService.selectProv();
    }

    //根据id查询下级列表
    @RequestMapping("/selectNextListById")
    @ResponseBody
    public List<China> selectNextListById(int id) {
        return chinaService.selectNextListById(id);
    }

    //
}
