package com.moon.dao;

import com.moon.entity.Cartitem;
import java.util.List;

public interface CartitemMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table cartitem
     *
     * @mbg.generated Mon Sep 26 16:01:30 CST 2022
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table cartitem
     *
     * @mbg.generated Mon Sep 26 16:01:30 CST 2022
     */
    int insert(Cartitem record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table cartitem
     *
     * @mbg.generated Mon Sep 26 16:01:30 CST 2022
     */
    Cartitem selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table cartitem
     *
     * @mbg.generated Mon Sep 26 16:01:30 CST 2022
     */
    List<Cartitem> selectAll();

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table cartitem
     *
     * @mbg.generated Mon Sep 26 16:01:30 CST 2022
     */
    int updateByPrimaryKey(Cartitem record);
}