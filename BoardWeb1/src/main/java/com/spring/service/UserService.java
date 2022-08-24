package com.spring.service;

import com.spring.user.UserVO;

public interface UserService {
	
	//로그인 처리
	public boolean login(UserVO vo);
}
