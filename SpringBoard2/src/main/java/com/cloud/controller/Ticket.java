package com.cloud.controller;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class Ticket {
	
	//�ʵ�
	private int tno;		//Ƽ�Ϲ�ȣ
	private String owner;	//������
	private String grade;	//���
}
