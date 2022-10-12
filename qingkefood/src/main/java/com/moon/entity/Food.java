package com.moon.entity;

import java.io.Serializable;
import java.util.Date;
/**
 * food 实体类
 * Fri Sep 23 16:17:10 CST 2022
 * @Mystery
 */ 
public class Food implements Serializable {
	private static final long serialVersionUID = 1L;
	private Integer id;
	private String name;
	private Double price;
	private Integer providerId;
	private Date createtime;
	private Integer state;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id=id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name=name;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price=price;
	}

	public Integer getProviderId() {
		return providerId;
	}

	public void setProviderId(Integer providerId) {
		this.providerId=providerId;
	}

	public Date getCreatetime() {
		return createtime;
	}

	public void setCreatetime(Date createtime) {
		this.createtime=createtime;
	}

	public Integer getState() {
		return state;
	}

	public void setState(Integer state) {
		this.state=state;
	}

}

