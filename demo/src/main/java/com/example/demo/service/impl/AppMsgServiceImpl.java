package com.example.demo.service.impl;

import javax.annotation.Resource;
import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.example.demo.domain.AppMsg;
import com.example.demo.repository.AppMsgRepository;
import com.example.demo.service.AppMsgService;

@Service
@Transactional
public class AppMsgServiceImpl implements AppMsgService {

	@Resource
	private AppMsgRepository appMsgRepository; 
	
	@Override
	public AppMsg findById(Integer id) {
		return appMsgRepository.findById(id);
	}
	
}
