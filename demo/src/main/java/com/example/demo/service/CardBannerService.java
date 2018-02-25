package com.example.demo.service;

import java.util.List;

import com.example.demo.domain.CardBanner;

public interface CardBannerService {
	
	CardBanner getById(Long id);
	
	List<CardBanner> queryBannerrList();
}
