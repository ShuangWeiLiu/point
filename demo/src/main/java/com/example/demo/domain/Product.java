package com.example.demo.domain;

import java.io.Serializable;

import com.example.demo.domain.common.ElasticSearchObject;

public class Product extends ElasticSearchObject implements Serializable {

	private static final long serialVersionUID = 1723144685948164928L;
	public static final String INDEX_NAME = "lmshop"; 
	public static final String TYPE = "product";
	
	private Long id; // ID
	private String name; // 名称
	private String intro; // 简介
	private String thumb; // 缩略图
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getIntro() {
		return intro;
	}
	public void setIntro(String intro) {
		this.intro = intro;
	}
	public String getThumb() {
		return thumb;
	}
	public void setThumb(String thumb) {
		this.thumb = thumb;
	}
	
}
