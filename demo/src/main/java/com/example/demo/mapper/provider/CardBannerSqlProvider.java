package com.example.demo.mapper.provider;

import org.apache.ibatis.jdbc.SQL;

public class CardBannerSqlProvider {
	
	public String getById(Long tid) {
		System.out.println("----id is:" + tid);
		SQL sql = new SQL() {{
			SELECT("*");
			FROM("card_banner");
			WHERE("tid = #{tid}");
		}};
		
		System.out.println("-----sqlStr:" + sql);
		return sql.toString();
	}
	
}
