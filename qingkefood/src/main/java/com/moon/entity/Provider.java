package com.moon.entity;

import java.io.Serializable;
import java.util.Date;
/**
 * provider 实体类
 * Fri Sep 23 16:17:10 CST 2022
 * @Mystery
 */ 
public class Provider implements Serializable {
	private static final long serialVersionUID = 1L;
	private Integer id;
	private String name;
	private Integer typeId;
	private String detail;
	private Integer consume;
	private String location;
	private Date createtime;
	private Integer state;
	private String imgsrc;

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

	public Integer getTypeId() {
		return typeId;
	}

	public void setTypeId(Integer typeId) {
		this.typeId=typeId;
	}

	public String getDetail() {
		return detail;
	}

	public void setDetail(String detail) {
		this.detail=detail;
	}

	public Integer getConsume() {
		return consume;
	}

	public void setConsume(Integer consume) {
		this.consume=consume;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location=location;
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

	public String getImgsrc() {
		return imgsrc;
	}

	public void setImgsrc(String imgsrc) {
		this.imgsrc=imgsrc;
	}

}

