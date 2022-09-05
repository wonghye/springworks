package com.cloud.security.domain;

import java.util.Collection;
import java.util.stream.Collectors;

import javax.annotation.processing.Generated;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;

import com.cloud.domain.MemberVO;

import lombok.Getter;

@Getter
public class CustomUser extends User { // User를 상속한 customer 클래스

	private static final long serialVersionUID = 13L;

	private MemberVO member;
	
	//스프링 시큐리티의 제공되는 생성자
	public CustomUser(String username, String password,		
			Collection<? extends GrantedAuthority> authorities) {
		super(username, password, authorities);
	}
	
	//memberVO를 파라미터로 전달해서 생성자를 호출
	public CustomUser(MemberVO vo) {
		super(vo.getUserid(), vo.getUserpw(),
				vo.getAuthList()
				.stream()
				.map(auth -> new SimpleGrantedAuthority(auth.getAuth()))
				.collect(Collectors.toList())
				);
		this.member = vo;
	}

	
	
	
}