package com.example.demo.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectProvider;

import com.example.demo.domain.CardBanner;
import com.example.demo.mapper.provider.CardBannerSqlProvider;

@Mapper
public interface CardBannerMapper {
	
	@SelectProvider(type = CardBannerSqlProvider.class, method="getById")
	CardBanner getById(Long id);
	
	@Select({
        "SELECT title, image, module, type, bid, bname, seqno, descp ",
        "from card_banner WHERE state = 1 order by seqno"
    })
    List<CardBanner> queryBannerrList();
}
