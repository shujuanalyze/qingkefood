package com.moon.entity;

import java.io.Serializable;

public class China implements Serializable {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column china.Id
     *
     * @mbg.generated Mon Sep 26 16:01:30 CST 2022
     */
    private Integer id;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column china.Name
     *
     * @mbg.generated Mon Sep 26 16:01:30 CST 2022
     */
    private String name;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column china.Pid
     *
     * @mbg.generated Mon Sep 26 16:01:30 CST 2022
     */
    private Integer pid;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table china
     *
     * @mbg.generated Mon Sep 26 16:01:30 CST 2022
     */
    private static final long serialVersionUID = 1L;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column china.Id
     *
     * @return the value of china.Id
     *
     * @mbg.generated Mon Sep 26 16:01:30 CST 2022
     */
    public Integer getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column china.Id
     *
     * @param id the value for china.Id
     *
     * @mbg.generated Mon Sep 26 16:01:30 CST 2022
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column china.Name
     *
     * @return the value of china.Name
     *
     * @mbg.generated Mon Sep 26 16:01:30 CST 2022
     */
    public String getName() {
        return name;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column china.Name
     *
     * @param name the value for china.Name
     *
     * @mbg.generated Mon Sep 26 16:01:30 CST 2022
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column china.Pid
     *
     * @return the value of china.Pid
     *
     * @mbg.generated Mon Sep 26 16:01:30 CST 2022
     */
    public Integer getPid() {
        return pid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column china.Pid
     *
     * @param pid the value for china.Pid
     *
     * @mbg.generated Mon Sep 26 16:01:30 CST 2022
     */
    public void setPid(Integer pid) {
        this.pid = pid;
    }
}