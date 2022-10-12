package com.moon.service;

import com.moon.dto.CartDto;
import com.moon.entity.Cartitem;

public interface CartService {
    //新增购物车项
    public void insert(int foodId, String foodName, double price, int userId);

    //根据商品ID/用户ID获取购物车项
    public Cartitem selectByFoodIdAndUserId(int foodId, int userId);

    //更新购物车项
    public void update(int foodId, int fcount, double sumPrice, int userId);

    //添加1件商品到购物车
    public default void addOneFoodToCart(int foodId, String foodName, double price, int userId) {
        Cartitem cartitem = this.selectByFoodIdAndUserId(foodId, userId);
        if (cartitem == null) {
            this.insert(foodId, foodName, price, userId);
        } else {
            int fcount = cartitem.getFcount() + 1;
            double sumPrice = cartitem.getPrice() * fcount;
            this.update(foodId, fcount, sumPrice, userId);
        }
    }

    //根据用户id获取购物车项列表
    public CartDto selectByUserId(int userId);

    //根据商品id/用户id删除
    public void deleteByFoodId(int foodId, int userId);

    //清空购物车
    public void clear(int userId);

    //
}
