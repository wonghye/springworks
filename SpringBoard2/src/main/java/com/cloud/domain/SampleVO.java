package com.cloud.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor	// 기본 생성자 사용할 경우 필요
@AllArgsConstructor
@Data
public class SampleVO {
	
	//필드
	private Integer mno;		//회원번호
	private String firstName;	//이름
	private String lastName;	//성
	
	
	
}
