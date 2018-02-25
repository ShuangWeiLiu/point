package com.example.demo.service;

import java.io.IOException;
import java.util.List;

import com.example.demo.domain.Fulltext;

import io.searchbox.core.SearchResult.Hit;

public interface FulltextEsService {

	void save(Fulltext fulltext);
	
	void saveFulltext(List<Fulltext> entityList); 
    
	List<Hit<Fulltext, Void>> searchFulltext(String searchContent) throws IOException;
	
	List<Hit<Fulltext, Void>> searchAllFulltext() throws IOException;
	
	List<Hit<Fulltext, Void>> searchFulltextByScroll() throws IOException;
	
}
