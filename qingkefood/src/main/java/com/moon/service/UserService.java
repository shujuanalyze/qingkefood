package com.moon.service;

import com.moon.entity.Fuser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    //根据账号密码获取用户
    public Fuser selectByAccountAndPassword(String account, String password) {
        String sql = "select * from fuser where account=? and password=?";
        List<Fuser> list = jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Fuser.class), account, password);
        if (list == null || list.size() < 1) {
            return null;
        }
        return list.get(0);
    }

    //
}
