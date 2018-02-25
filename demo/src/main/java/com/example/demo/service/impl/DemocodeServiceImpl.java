package com.example.demo.service.impl;

import java.util.Collection;
import java.util.List;

import javax.annotation.Resource;
import javax.transaction.Transactional;

import org.springframework.data.domain.Pageable;
import org.springframework.data.solr.core.query.result.HighlightPage;
import org.springframework.data.solr.core.query.result.SolrResultPage;
import org.springframework.stereotype.Service;

import com.example.demo.domain.Democode;
import com.example.demo.repository.DemocodeRepository;
import com.example.demo.service.DemocodeService;

@Service
@Transactional
public class DemocodeServiceImpl implements DemocodeService {

	@Resource
	private DemocodeRepository democodeRepository;  
	
	@Override
	public List<Democode> findByName(String name) {
		return democodeRepository.findByNameLike(name);
	}

	@Override
	public Democode save(Democode democode) {
		return democodeRepository.save(democode);
	}

	@Override
	public SolrResultPage<Democode> findAll() {
		return democodeRepository.findAll();
	}

	@Override
	public HighlightPage<Democode> findByNameIn(Collection<String> name, Pageable page) {
		return democodeRepository.findByNameIn(name, page);
	}
	
}
