package com.example.demo;

import javax.annotation.Resource;

import org.apache.solr.client.solrj.SolrClient;
import org.apache.solr.client.solrj.impl.HttpSolrClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.data.solr.repository.config.EnableSolrRepositories;

@Configuration
@EnableSolrRepositories(basePackages={"com.example.demo.repository"}, multicoreSupport=true)
public class SolrContext {
	
	static final String SOLR_HOST = "http://127.0.0.1:8983/solr/";

	@Resource 
	private Environment environment;

	@Bean
	public SolrClient solrClient() {
//		String solrHost = environment.getRequiredProperty(SOLR_HOST);
		HttpSolrClient solrClient = new HttpSolrClient(SOLR_HOST);
		
	    return solrClient;
	}
	
}
