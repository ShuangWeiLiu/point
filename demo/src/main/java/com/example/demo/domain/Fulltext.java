package com.example.demo.domain;

import java.io.Serializable;

public class Fulltext implements Serializable {
	
	private static final long serialVersionUID = -763638353551774166L; 
    
	public static final String INDEX_NAME = "index"; 
	    
	public static final String TYPE = "fulltext";
	
	private Long id;
	
	private String content;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}
	
}
