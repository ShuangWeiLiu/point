package com.example.demo.service;

import java.io.IOException;
import java.util.List;

import com.example.demo.domain.Product;

import io.searchbox.core.SearchResult.Hit;

public interface ProductService {
	
	void save(Product product);
	
	void saveList(List<Product> entityList);
	
	List<Hit<Product, Void>> searchAll(String searchContent) throws IOException;
	
}
