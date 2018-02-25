package com.example.demo.repository;

import java.util.Collection;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.Repository;
import org.springframework.data.solr.core.query.result.FacetPage;
import org.springframework.data.solr.core.query.result.HighlightPage;
import org.springframework.data.solr.core.query.result.SolrResultPage;
import org.springframework.data.solr.repository.Boost;
import org.springframework.data.solr.repository.Facet;
import org.springframework.data.solr.repository.Highlight;
import org.springframework.data.solr.repository.Query;

import com.example.demo.domain.Democode;

public interface DemocodeRepository extends Repository<Democode, Long> {
	
	SolrResultPage<Democode> findAll();
	
	List<Democode> findByNameLike(String name);

	Democode save(Democode democode);
	
	Page<Democode> findByPopularity(Integer popularity, Pageable page);
	
	Page<Democode> findByNameOrDescription(@Boost(2) String name, String description, Pageable page);
	
	@Highlight
	HighlightPage<Democode> findByNameIn(Collection<String> name, Pageable page);
	
	@Query(value = "name:?0")
	@Facet(fields = { "cat" }, limit=20)
	FacetPage<Democode> findByNameAndFacetOnCategory(String name, Pageable page);
}
