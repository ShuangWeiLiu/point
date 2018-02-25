package com.example.demo.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.Repository;

import com.example.demo.domain.AppMsg;

public interface AppMsgRepository extends Repository<AppMsg, Long> {

	Page<AppMsg> findAll(Pageable pageable);

	AppMsg findById(Integer id);
	
}
