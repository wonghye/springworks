package com.spring.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.user.UserDAO;
import com.spring.user.UserVO;

//@Service("userService")
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDAO UserDAO;
	
	//setter ¿Œ¡ßº« 
	public void setUserDAO(UserDAO userDAO) {
		this.UserDAO = userDAO;
	}
	
	@Override
	public boolean login(UserVO vo) {
		return UserDAO.login(vo);
	}

}
