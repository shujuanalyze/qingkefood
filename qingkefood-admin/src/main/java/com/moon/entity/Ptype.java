package com.moon.entity;

import java.io.Serializable;
import java.util.Date;

public class Ptype implements Serializable {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column ptype.id
     *
     * @mbg.generated Mon Sep 26 16:01:30 CST 2022
     */
    private Integer id;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column ptype.name
     *
     * @mbg.generated Mon Sep 26 16:01:30 CST 2022
     */
    private String name;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column ptype.createtime
     *
     * @mbg.generated Mon Sep 26 16:01:30 CST 2022
     */
    private Date createtime;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column ptype.state
     *
     * @mbg.generated Mon Sep 26 16:01:30 CST 2022
     */
    private Integer state;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table ptype
     *
     * @mbg.generated Mon Sep 26 16:01:30 CST 2022
     */
    private static final long serialVersionUID = 1L;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column ptype.id
     *
     * @return the value of ptype.id
     *
     * @mbg.generated Mon Sep 26 16:01:30 CST 2022
     */
    public Integer getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column ptype.id
     *
     * @param id the value for ptype.id
     *
     * @mbg.generated Mon Sep 26 16:01:30 CST 2022
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column ptype.name
     *
     * @return the value of ptype.name
     *
     * @mbg.generated Mon Sep 26 16:01:30 CST 2022
     */
    public String getName() {
        return name;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column ptype.name
     *
     * @param name the value for ptype.name
     *
     * @mbg.generated Mon Sep 26 16:01:30 CST 2022
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column ptype.createtime
     *
     * @return the value of ptype.createtime
     *
     * @mbg.generated Mon Sep 26 16:01:30 CST 2022
     */
    public Date getCreatetime() {
        return createtime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column ptype.createtime
     *
     * @param createtime the value for ptype.createtime
     *
     * @mbg.generated Mon Sep 26 16:01:30 CST 2022
     */
    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column ptype.state
     *
     * @return the value of ptype.state
     *
     * @mbg.generated Mon Sep 26 16:01:30 CST 2022
     */
    public Integer getState() {
        return state;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column ptype.state
     *
     * @param state the value for ptype.state
     *
     * @mbg.generated Mon Sep 26 16:01:30 CST 2022
     */
    public void setState(Integer state) {
        this.state = state;
    }
}