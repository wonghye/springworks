package com.cloud.domain;

import java.io.Serializable;
import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class BoardVO2 implements Serializable{

	private static final long serialVersionUID = 10L;
	
	private int bno;         //글번호
	private String title;    //제목
	private String writer;   //작성자
	private String content;  //내용
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date regDate;    //작성일
	private int cnt;         //조회수
	
}