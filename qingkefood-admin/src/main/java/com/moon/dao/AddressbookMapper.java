package com.moon.dao;

import com.moon.entity.Addressbook;
import java.util.List;

public interface AddressbookMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table addressbook
     *
     * @mbg.generated Mon Sep 26 16:01:30 CST 2022
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table addressbook
     *
     * @mbg.generated Mon Sep 26 16:01:30 CST 2022
     */
    int insert(Addressbook record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table addressbook
     *
     * @mbg.generated Mon Sep 26 16:01:30 CST 2022
     */
    Addressbook selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table addressbook
     *
     * @mbg.generated Mon Sep 26 16:01:30 CST 2022
     */
    List<Addressbook> selectAll();

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table addressbook
     *
     * @mbg.generated Mon Sep 26 16:01:30 CST 2022
     */
    int updateByPrimaryKey(Addressbook record);
}