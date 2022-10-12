package com.moon.service;

import com.moon.dto.CartDto;
import com.moon.entity.Cartitem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.support.TransactionCallback;
import org.springframework.transaction.support.TransactionTemplate;

import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.Date;
import java.util.List;

@Service
public class OrderService {
    @Autowired
    private JdbcTemplate jdbcTemplate;
    @Autowired
    @Qualifier("cartServiceRdImpl")
    private CartService cartService;

    //新增主订单,返回订单号.
    public int insertOrder(String fulladdr, int userId) {
        //购物车信息
        CartDto cartDto = cartService.selectByUserId(userId);
        //地址信息
        String[] addrSpl = fulladdr.split("#");
        //新增主订单,并取回订单号.
        StringBuilder sqlbdr = new StringBuilder(" insert into forder(totalprice,userId,prov,city,district,addr,createtime,state) ");
        sqlbdr.append("values(?,?,?,?,?,?,?,?)");
        KeyHolder keyHolder = new GeneratedKeyHolder();
        //jdbc操作
        jdbcTemplate.update((conn) -> {
            PreparedStatement st = conn.prepareStatement(sqlbdr.toString(), Statement.RETURN_GENERATED_KEYS);
            st.setDouble(1, cartDto.getTotalPrice());
            st.setInt(2, userId);
            st.setString(3, addrSpl[0]);
            st.setString(4, addrSpl[1]);
            st.setString(5, addrSpl[2]);
            st.setString(6, addrSpl[3]);
            st.setDate(7, new java.sql.Date(new java.util.Date().getTime()));
            st.setInt(8, 1);
            return st;
        }, keyHolder);
        int nid = keyHolder.getKey().intValue();
        return nid;
    }

    //新增订单明细
    public void insertOrderDetail(int orderId, int userId) {
        //购物车信息
        CartDto cartDto = cartService.selectByUserId(userId);
        List<Cartitem> items = cartDto.getItems();
        for (Cartitem item : items) {
            String sql = " insert into orderdetail(foodId,foodName,price,fcount,sumprice,orderId,createtime,state) ";
            sql += " values(?,?,?,?,?,?,?,?) ";
            jdbcTemplate.update(sql, item.getFoodId(), item.getFoodName(), item.getPrice(), item.getFcount(), item.getSumPrice(), orderId, new Date(), 1);
        }
    }

    //新增订单/订单明细/清空购物车
    @Transactional(rollbackFor = Exception.class)
    public void insertOrderAndDetails(String fulladdr, int userId) {
        //新增订单
        int orderId = this.insertOrder(fulladdr, userId);
        //新增订单明细
        this.insertOrderDetail(orderId, userId);
        //人工模拟异常
        //int x = 1 / 0;
        //清空购物车
        cartService.clear(userId);
    }

    //
}
