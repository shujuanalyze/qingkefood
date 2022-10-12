package com.moon.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.SetOperations;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Set;

@RequestMapping("/redisTest")
@Controller
public class RedisTestController {
    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @RequestMapping("/call")
    @ResponseBody
    public Set<String> call() {
        SetOperations ops = stringRedisTemplate.opsForSet();
        return ops.members("teacher");
    }

    //
}
