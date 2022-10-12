package com.moon.service;

import com.moon.entity.Provider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProviderService {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    //根据类型id获取商家列表
    public List<Provider> selectByTypeId(int typeId) {
        if (typeId == 0) {
            String sql = "select * from provider";
            return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Provider.class));
        } else {
            String sql = "select * from provider where typeId=?";
            return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Provider.class), typeId);
        }
    }

    //根据id获取商家信息
    public Provider selectById(int providerId) {
        String sql = "select * from provider where id=?";
        List<Provider> list = jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Provider.class), providerId);
        if (list == null || list.size() < 1) {
            return null;
        }
        return list.get(0);
    }

    //
}
