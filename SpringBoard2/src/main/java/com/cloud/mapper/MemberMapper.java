package com.cloud.mapper;

import com.cloud.domain.MemberVO;

public interface MemberMapper {

	//ȸ�� �� ����
	public MemberVO read(String userid); 
	
	//ȸ�� ����
	public void insertMember(MemberVO member);
	
	
	
	
}
