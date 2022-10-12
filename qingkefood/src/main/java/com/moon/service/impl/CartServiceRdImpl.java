package com.moon.service.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.moon.dto.CartDto;
import com.moon.entity.Cartitem;
import com.moon.service.CartService;
import com.moon.utils.JsonUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;

@Service
public class CartServiceRdImpl implements CartService {
    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @Override
    public void insert(int foodId, String foodName, double price, int userId) {
        HashOperations ops = stringRedisTemplate.opsForHash();
        int fcount = 1;
        double sumprice = price * fcount;
        //创建cartItem对象
        Cartitem item = new Cartitem();
        item.setCreatetime(new Date());
        item.setFcount(fcount);
        item.setFoodId(foodId);
        item.setFoodName(foodName);
        item.setId(0);
        item.setPrice(price);
        item.setSumPrice(sumprice);
        item.setState(1);
        item.setUserId(userId);
        //存入redis
        ops.put(userId + "", foodId + "", JsonUtils.toJSON(item));
    }

    @Override
    public Cartitem selectByFoodIdAndUserId(int foodId, int userId) {
        HashOperations ops = stringRedisTemplate.opsForHash();
        Object val = ops.get(userId + "", foodId + "");
        if (val == null) {
            return null;
        }
        Cartitem cartitem = JsonUtils.toObj(val.toString(), Cartitem.class);
        return cartitem;
    }

    @Override
    public void update(int foodId, int fcount, double sumPrice, int userId) {
        Cartitem cartitem = this.selectByFoodIdAndUserId(foodId, userId);
        cartitem.setFcount(fcount);
        cartitem.setSumPrice(sumPrice);
        HashOperations ops = stringRedisTemplate.opsForHash();
        ops.put(userId + "", foodId + "", JsonUtils.toJSON(cartitem));
    }

    @Override
    public CartDto selectByUserId(int userId) {
        HashOperations ops = stringRedisTemplate.opsForHash();
        //获取cartItems/totalPrices
        List<String> list = ops.values(userId + "");
        List<Cartitem> cartItems = new ArrayList<Cartitem>();
        double totalPrice = 0;
        for (String str : list) {
            Cartitem cartitem = JsonUtils.toObj(str, Cartitem.class);
            cartItems.add(cartitem);
            totalPrice += cartitem.getSumPrice();
        }
        //组建CartDto
        CartDto cartDto = new CartDto();
        cartDto.setItems(cartItems);
        cartDto.setTotalPrice(totalPrice);
        return cartDto;
    }

    //根据商品id删除
    @Override
    public void deleteByFoodId(int foodId, int userId) {
        HashOperations ops = stringRedisTemplate.opsForHash();
        ops.delete(userId + "", foodId + "");
    }

    @Override
    public void clear(int userId) {
        stringRedisTemplate.delete(userId + "");
    }

    //
}
