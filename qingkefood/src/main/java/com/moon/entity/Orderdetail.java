package com.moon.entity;

import java.io.Serializable;
import java.util.Date;
/**
 * orderdetail 实体类
 * Fri Sep 23 16:17:10 CST 2022
 * @Mystery
 */ 
public class Orderdetail implements Serializable {
	private static final long serialVersionUID = 1L;
	private Integer id;
	private Integer foodId;
	private String foodName;
	private Double price;
	private Integer fcount;
	private Double sumprice;
	private Integer orderId;
	private Date createtime;
	private Integer state;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id=id;
	}

	public Integer getFoodId() {
		return foodId;
	}

	public void setFoodId(Integer foodId) {
		this.foodId=foodId;
	}

	public String getFoodName() {
		return foodName;
	}

	public void setFoodName(String foodName) {
		this.foodName=foodName;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price=price;
	}

	public Integer getFcount() {
		return fcount;
	}

	public void setFcount(Integer fcount) {
		this.fcount=fcount;
	}

	public Double getSumprice() {
		return sumprice;
	}

	public void setSumprice(Double sumprice) {
		this.sumprice=sumprice;
	}

	public Integer getOrderId() {
		return orderId;
	}

	public void setOrderId(Integer orderId) {
		this.orderId=orderId;
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

