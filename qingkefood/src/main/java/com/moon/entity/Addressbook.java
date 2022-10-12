package com.moon.entity;

import java.io.Serializable;
import java.util.Date;
/**
 * addressbook 实体类
 * Fri Sep 23 16:17:10 CST 2022
 * @Mystery
 */ 
public class Addressbook implements Serializable {
	private static final long serialVersionUID = 1L;
	private Integer id;
	private String fulladdr;
	private Integer userId;
	private Date createtime;
	private Integer state;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id=id;
	}

	public String getFulladdr() {
		return fulladdr;
	}

	public void setFulladdr(String fulladdr) {
		this.fulladdr=fulladdr;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId=userId;
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

