package com.spring.vo;

import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class FriendVO2 {
	private String name;
	private int age;
	
	/*public FriendVO2(String name, int age) { //파라미터를 가진 생성자
		super();
		this.name = name;
		this.age = age;
	}*/

}
