package com.cloud.domain;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Criteria {
	
	private int pageNum;  // 페이지 번호
	private int amount;   //페이지당 게시글 수
	
	private String type;	// T, C, W, TC, TW, TCW (배열)
	private String keyword;	// 검색어
	
	
	public Criteria() {  // 기본 생성자(매개변수 없는 생성자)
		this(1,10);		// 매개변수 생성자 호출 
	}
	
	public Criteria(int pageNum, int amount) {
		this.pageNum = pageNum;
		this.amount = amount;
	}
	
	//타입을 저장할 메소드 정의(배열로 반환, 문자열 분리)
	public String[] getTypeArr() {
		// 삼항, 조건 연산자 사용
		return type == null ? new String[] {} : type.split(""); 
	}
	
	
	
}
