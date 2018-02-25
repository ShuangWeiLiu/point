package com.example.demo.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.example.demo.domain.CardBanner;
import com.example.demo.mapper.CardBannerMapper;
import com.example.demo.service.CardBannerService;

@Service
public class CardBannerServiceImpl implements CardBannerService {
	
	@Resource
	private CardBannerMapper cardBannerMapper;

	@Override
	public CardBanner getById(Long id) {
		return cardBannerMapper.getById(id);
	}

	@Override
	public List<CardBanner> queryBannerrList() {
		return cardBannerMapper.queryBannerrList();
	}
	
}
