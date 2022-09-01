package com.cloud.mapper;

import com.cloud.domain.MemberVO;

public interface MemberMapper {

	//회원 상세 보기
	public MemberVO read(String userid); 
	
	//회원 가입
	public void insertMember(MemberVO member);
	
	
	
	
}
