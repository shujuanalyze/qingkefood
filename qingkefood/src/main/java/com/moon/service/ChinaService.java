package com.moon.service;

import com.moon.entity.China;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ChinaService {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    //查询省份列表
    public List<China> selectProv() {
        String sql = "select * from china where pid=-1";
        return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(China.class));
    }

    //根据id查询下级列表
    public List<China> selectNextListById(int id) {
        String sql = "select * from china where pid=?";
        return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(China.class), id);
    }

    //
}
