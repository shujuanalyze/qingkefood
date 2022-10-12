package com.moon.service;

import com.moon.entity.Ptype;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PtypeService {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    //获取所有商家类型列表
    public List<Ptype> selectAll() {
        String sql = "select * from ptype";
        return jdbcTemplate.query(sql, new BeanPropertyRowMapper(Ptype.class));
    }

    //
}
