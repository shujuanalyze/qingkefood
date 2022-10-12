package com.moon.entity;

import java.io.Serializable;
import java.util.Date;
/**
 * china 实体类
 * Fri Sep 23 16:17:10 CST 2022
 * @Mystery
 */ 
public class China implements Serializable {
	private static final long serialVersionUID = 1L;
	private Integer Id;
	private String Name;
	private Integer Pid;

	public Integer getId() {
		return Id;
	}

	public void setId(Integer Id) {
		this.Id=Id;
	}

	public String getName() {
		return Name;
	}

	public void setName(String Name) {
		this.Name=Name;
	}

	public Integer getPid() {
		return Pid;
	}

	public void setPid(Integer Pid) {
		this.Pid=Pid;
	}

}

