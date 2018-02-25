package com.example.demo.service.impl;

import java.io.IOException;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.example.demo.domain.Product;
import com.example.demo.service.ElasticSearchDao;
import com.example.demo.service.ProductService;

import io.searchbox.core.SearchResult.Hit;

@Service
public class ProductServiceImpl implements ProductService {

	@Resource
	private ElasticSearchDao elasticSearchDao;
	
	@Override
	public void save(Product product) {
		elasticSearchDao.save(product, product.INDEX_NAME, product.TYPE);
	}

	@Override
	public void saveList(List<Product> entityList) {
		
	}

	@Override
	public List<Hit<Product, Void>> searchAll(String searchContent) throws IOException {
		return elasticSearchDao.searchAll(Product.INDEX_NAME, Product.class);
	}

}
