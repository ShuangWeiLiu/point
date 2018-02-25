package com.example.demo.service;

import java.util.Collection;
import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.solr.core.query.result.HighlightPage;
import org.springframework.data.solr.core.query.result.SolrResultPage;

import com.example.demo.domain.Democode;

public interface DemocodeService {
	
	SolrResultPage<Democode> findAll();
	
	List<Democode> findByName(String name);
	
	Democode save(Democode democode);
	
	HighlightPage<Democode> findByNameIn(Collection<String> name, Pageable page);
}
