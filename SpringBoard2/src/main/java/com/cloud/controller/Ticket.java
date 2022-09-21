package com.cloud.controller;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class Ticket {
	
	//필드
	private int tno;		//티켓번호
	private String owner;	//소유주
	private String grade;	//등급
}
