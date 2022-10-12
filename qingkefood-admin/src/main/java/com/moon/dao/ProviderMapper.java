package com.moon.dao;

import com.moon.entity.Provider;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface ProviderMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table provider
     *
     * @mbg.generated Mon Sep 26 16:01:30 CST 2022
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table provider
     *
     * @mbg.generated Mon Sep 26 16:01:30 CST 2022
     */
    int insert(Provider record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table provider
     *
     * @mbg.generated Mon Sep 26 16:01:30 CST 2022
     */
    Provider selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table provider
     *
     * @mbg.generated Mon Sep 26 16:01:30 CST 2022
     */
    List<Provider> selectAll();

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table provider
     *
     * @mbg.generated Mon Sep 26 16:01:30 CST 2022
     */
    int updateByPrimaryKey(Provider record);

    //根据类型查询商家列表
    @Select("select * from provider where typeId=#{typeId}")
    public List<Provider> selectByTypeId(@Param("typeId") int typeId);
}