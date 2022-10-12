package com.moon.entity;

import java.io.Serializable;
import java.util.Date;
/**
 * fuser 实体类
 * Fri Sep 23 16:17:10 CST 2022
 * @Mystery
 */ 
public class Fuser implements Serializable {
	private static final long serialVersionUID = 1L;
	private Integer id;
	private String account;
	private String password;
	private String nickname;
	private Date createtime;
	private Integer state;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id=id;
	}

	public String getAccount() {
		return account;
	}

	public void setAccount(String account) {
		this.account=account;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password=password;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname=nickname;
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

