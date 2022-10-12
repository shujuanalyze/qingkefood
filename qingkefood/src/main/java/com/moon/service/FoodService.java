package com.moon.service;

import com.moon.entity.Food;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FoodService {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    //根据商家id获得食品列表
    public List<Food> selectByProviderId(int providerId) {
        String sql = "select * from food where providerId=?";
        return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Food.class), providerId);
    }

    //
}
