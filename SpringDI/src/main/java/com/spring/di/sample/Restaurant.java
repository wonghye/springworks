package com.spring.di.sample;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Setter;

//생성자 주입
//Setter 주입
//Autowired -필드 위 주입

//@AllArgsConstructor  //생성자 주입
@Component
@Data
public class Restaurant {
	
	//@Autowired
	@Setter(onMethod_ = @Autowired)  //setter 인젝션
	private Chef chef;  //new Chef()
	
	/*public Restaurant(Chef chef) { //자바 방식의 생성자 만들기
		this.chef = chef;
	}*/
}
