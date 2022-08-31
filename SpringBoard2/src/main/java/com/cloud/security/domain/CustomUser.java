package com.cloud.security.domain;

import java.util.Collection;
import java.util.stream.Collectors;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;

import com.cloud.domain.MemberVO;

public class CustomUser extends User { // User�� ����� customer Ŭ����

	private static final long serialVersionUID = 13L;

	private MemberVO member;
	
	//������ ��ť��Ƽ�� �����Ǵ� ������
	public CustomUser(String username, String password,		
			Collection<? extends GrantedAuthority> authorities) {
		super(username, password, authorities);
	}
	
	//memberVO�� �Ķ���ͷ� �����ؼ� �����ڸ� ȣ��
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