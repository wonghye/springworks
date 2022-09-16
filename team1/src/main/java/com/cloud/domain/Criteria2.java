package com.cloud.domain;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Criteria2 {
	private int pageNum;  //페이지 번호
	private int amount;   //페이지당 게시글 수
	
	public Criteria2() {  //기본 생성자(매개변수 없는 생성자)
		this(1, 10);  //매개변수 생성자 호출
	}
	
	public Criteria2(int pageNum, int amount) {
		this.pageNum = pageNum;
		this.amount = amount;
	}
}