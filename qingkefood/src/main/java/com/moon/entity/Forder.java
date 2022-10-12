package com.moon.entity;

import java.io.Serializable;
import java.util.Date;
/**
 * forder 实体类
 * Fri Sep 23 16:17:10 CST 2022
 * @Mystery
 */ 
public class Forder implements Serializable {
	private static final long serialVersionUID = 1L;
	private Integer id;
	private Double totalprice;
	private Integer userId;
	private String prov;
	private String city;
	private String district;
	private String district2;
	private String addr;
	private Date createtime;
	private Integer state;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id=id;
	}

	public Double getTotalprice() {
		return totalprice;
	}

	public void setTotalprice(Double totalprice) {
		this.totalprice=totalprice;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId=userId;
	}

	public String getProv() {
		return prov;
	}

	public void setProv(String prov) {
		this.prov=prov;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city=city;
	}

	public String getDistrict() {
		return district;
	}

	public void setDistrict(String district) {
		this.district=district;
	}

	public String getDistrict2() {
		return district2;
	}

	public void setDistrict2(String district2) {
		this.district2=district2;
	}

	public String getAddr() {
		return addr;
	}

	public void setAddr(String addr) {
		this.addr=addr;
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

