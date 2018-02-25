package com.example.demo.domain;

import java.io.Serializable;

import javax.persistence.Id;

import org.apache.solr.client.solrj.beans.Field;
import org.springframework.data.solr.core.mapping.SolrDocument;

@SolrDocument(solrCoreName = "democode")
public class Democode implements Serializable {

	private static final long serialVersionUID = 201801111012001L;
	
	private Integer id;
	private String name;
	private String description;
	private Integer popularity;
	
	@Id
	@Field(value = "id")
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	
	@Field(value = "name")
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	@Field(value = "description")
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	@Field(value = "popularity")
	public Integer getPopularity() {
		return popularity;
	}
	public void setPopularity(Integer popularity) {
		this.popularity = popularity;
	}
	
}
