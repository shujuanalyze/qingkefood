package com.moon.service.impl;

import com.moon.dto.CartDto;
import com.moon.entity.Cartitem;
import com.moon.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class CartServiceDbImpl implements CartService {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    //新增购物车项
    public void insert(int foodId, String foodName, double price, int userId) {
        String sql = " insert into cartitem(foodId,foodName,price,fcount,sumprice,userId,createtime,state) ";
        sql += " values(?,?,?,?,?,?,?,?) ";
        int fcount = 1;
        double sumprice = price * fcount;
        jdbcTemplate.update(sql, foodId, foodName, price, fcount, sumprice, userId, new Date(), 1);
    }

    //根据商品ID/用户ID获取购物车项
    public Cartitem selectByFoodIdAndUserId(int foodId, int userId) {
        String sql = "select * from cartitem where foodId=? and userId=?";
        List<Cartitem> list = jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Cartitem.class), foodId, userId);
        if (list == null || list.size() < 1) {
            return null;
        }
        return list.get(0);
    }

    //更新购物车项
    public void update(int foodId, int fcount, double sumPrice, int userId) {
        String sql = "update cartitem set fcount=?,sumPrice=? where foodId=? and userId=?";
        jdbcTemplate.update(sql, fcount, sumPrice, foodId, userId);
    }

    //根据用户id获取购物车项列表
    public CartDto selectByUserId(int userId) {
        String sql = "select * from cartitem where userId=?";
        List<Cartitem> items = jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Cartitem.class), userId);
        double total = 0;
        for (Cartitem item : items) {
            total += item.getSumPrice();
        }
        //组建cartdto对象
        CartDto cartDto = new CartDto();
        cartDto.setItems(items);
        cartDto.setTotalPrice(total);
        return cartDto;
    }

    //根据商品id删除
    @Override
    public void deleteByFoodId(int foodId, int userId) {
        String sql = "delete from cartitem where foodId=? and userId=?";
        jdbcTemplate.update(sql, foodId, userId);
    }

    @Override
    public void clear(int userId) {
        String sql = "delete from cartitem where userId=?";
        jdbcTemplate.update(sql, userId);
    }

    //
}
