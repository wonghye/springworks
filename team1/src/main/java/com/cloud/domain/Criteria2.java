package com.cloud.domain;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Criteria2 {
	private int pageNum;  //������ ��ȣ
	private int amount;   //�������� �Խñ� ��
	
	public Criteria2() {  //�⺻ ������(�Ű����� ���� ������)
		this(1, 10);  //�Ű����� ������ ȣ��
	}
	
	public Criteria2(int pageNum, int amount) {
		this.pageNum = pageNum;
		this.amount = amount;
	}
}