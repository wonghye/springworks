package com.spring.mapper;

import org.apache.ibatis.annotations.Select;

//시간을 검색하는 인터페이스
public interface TimeMapper {
		
	@Select("SELECT sysdate FROM dual")
	public String getTime();
	
	public String getTime2();  // xml로 처리
}
