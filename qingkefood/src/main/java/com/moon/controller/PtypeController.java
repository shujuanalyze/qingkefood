package com.moon.controller;

import com.moon.entity.Ptype;
import com.moon.service.PtypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@RequestMapping("/ptype")
@Controller
public class PtypeController {
    @Autowired
    private PtypeService ptypeService;

    @RequestMapping("/selectAll")
    @ResponseBody
    public List<Ptype> selectAll() {
        return ptypeService.selectAll();
    }

    //
}
